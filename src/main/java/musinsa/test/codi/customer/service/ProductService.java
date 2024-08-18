package musinsa.test.codi.customer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import musinsa.test.codi.customer.mapper.ProductMapper;
import musinsa.test.codi.customer.domain.Product;
import musinsa.test.codi.customer.dto.BrandPriceDTO;
import musinsa.test.codi.customer.dto.CategoryPriceDTO;
import musinsa.test.codi.customer.dto.ProductInfoDTO;
import musinsa.test.codi.customer.response.MinMaxPriceResponse;
import musinsa.test.codi.customer.response.MinPriceBrandResponse;
import musinsa.test.codi.customer.response.ProductResponse;
import musinsa.test.codi.util.BrandUtil;
import musinsa.test.codi.util.CategoryUtil;
import musinsa.test.codi.util.PriceUtil;
import musinsa.test.codi.util.ProductUtil;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductMapper productMapper;

	public ProductResponse getMinPriceByCategory() {
		List<Product> products = productMapper.findAllProducts();
		// 카테고리별 최저 가격 계산
		Map<String, ProductInfoDTO> minPriceByCategory = CategoryUtil.calculateMinPriceByCategory(products);

		List<Integer> prices = minPriceByCategory.values().stream()
				.map(ProductInfoDTO::getPrice)
				.collect(Collectors.toList());

		int totalMinPrice = PriceUtil.calculateTotalPrice(prices);

		return new ProductResponse(new ArrayList<>(minPriceByCategory.values()), totalMinPrice);
	}

	public MinPriceBrandResponse getMinPriceBrandForAllCategories() {
		List<Product> products = productMapper.findAllProducts();

		// 브랜드별 총 가격 계산
		Map<String, Integer> brandTotalPrices = BrandUtil.calculateBrandTotalPrices(products);

		// 최저 가격 브랜드 선택
		String minBrand = BrandUtil.findMinPriceBrand(brandTotalPrices);

		// 최저 가격 브랜드의 제품 정보 추출
		List<CategoryPriceDTO> categoryPrices = ProductUtil.extractProductsByBrand(products, minBrand).stream()
				.map(productInfo -> new CategoryPriceDTO(
						productInfo.getCategoryName(),
						PriceUtil.formatPrice(productInfo.getPrice())
				))
				.collect(Collectors.toList());

		// 총 가격 계산
		int totalMinPrice = PriceUtil.calculateTotalPrice(
				categoryPrices.stream()
						.map(CategoryPriceDTO::getPrice)
						.map(price -> Integer.parseInt(price.replace(",", "")))
						.collect(Collectors.toList())
		);

		return new MinPriceBrandResponse(
				new MinPriceBrandResponse.BrandDetail(
						minBrand,
						categoryPrices,
						PriceUtil.formatPrice(totalMinPrice)
				)
		);
	}

	public MinMaxPriceResponse getMinMaxPriceBrandsByCategory(String categoryName) {
		List<Product> products = productMapper.findAllProducts();

		// 최저가 및 최고가 제품 정보 추출
		List<BrandPriceDTO> minPriceProducts = CategoryUtil.findMinPriceProducts(products, categoryName);
		List<BrandPriceDTO> maxPriceProducts = CategoryUtil.findMaxPriceProducts(products, categoryName);

		return new MinMaxPriceResponse(categoryName, minPriceProducts, maxPriceProducts);
	}
}