package musinsa.test.codi.util;

import musinsa.test.codi.customer.domain.Product;
import musinsa.test.codi.customer.dto.ProductInfoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductUtil {

    // 특정 브랜드의 제품 정보 추출
    public static List<ProductInfoDTO> extractProductsByBrand(List<Product> products, String brandName) {
        return products.stream()
                .filter(product -> product.getBrand().getBrandName().equals(brandName))
                .map(product -> new ProductInfoDTO(
                        product.getCategory().getCategoryName(),
                        product.getBrand().getBrandName(),
                        product.getPrice()
                ))
                .collect(Collectors.toList());
    }
}