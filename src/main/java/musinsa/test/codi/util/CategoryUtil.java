package musinsa.test.codi.util;
import musinsa.test.codi.customer.domain.Product;
import musinsa.test.codi.customer.dto.BrandPriceDTO;
import musinsa.test.codi.customer.dto.ProductInfoDTO;

import java.util.*;

public class CategoryUtil {

    // 카테고리별 최저 가격 계산
    public static Map<String, ProductInfoDTO> calculateMinPriceByCategory(List<Product> products) {
        Map<String, ProductInfoDTO> minPriceByCategory = new HashMap<>();

        for (Product product : products) {
            String categoryName = product.getCategory().getCategoryName();
            if (!minPriceByCategory.containsKey(categoryName) || product.getPrice() < minPriceByCategory.get(categoryName).getPrice()) {
                ProductInfoDTO dto = new ProductInfoDTO(
                        categoryName,
                        product.getBrand().getBrandName(),
                        product.getPrice()
                );
                minPriceByCategory.put(categoryName, dto);
            }
        }

        return minPriceByCategory;
    }

    // 특정 카테고리에서 최저가 제품 추출
    public static List<BrandPriceDTO> findMinPriceProducts(List<Product> products, String categoryName) {
        return products.stream()
                .filter(product -> product.getCategory().getCategoryName().equals(categoryName))
                .min(Comparator.comparingInt(Product::getPrice))
                .map(product -> new BrandPriceDTO(
                        product.getBrand().getBrandName(),
                        PriceUtil.formatPrice(product.getPrice())
                ))
                .map(List::of)
                .orElse(List.of());
    }

    // 특정 카테고리에서 최고가 제품 추출
    public static List<BrandPriceDTO> findMaxPriceProducts(List<Product> products, String categoryName) {
        return products.stream()
                .filter(product -> product.getCategory().getCategoryName().equals(categoryName))
                .max(Comparator.comparingInt(Product::getPrice))
                .map(product -> new BrandPriceDTO(
                        product.getBrand().getBrandName(),
                        PriceUtil.formatPrice(product.getPrice())
                ))
                .map(List::of)
                .orElse(List.of());
    }
}