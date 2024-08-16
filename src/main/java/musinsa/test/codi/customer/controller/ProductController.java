package musinsa.test.codi.customer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import musinsa.test.codi.customer.service.ProductService;
import musinsa.test.codi.customer.response.MinMaxPriceResponse;
import musinsa.test.codi.customer.response.MinPriceBrandResponse;
import musinsa.test.codi.customer.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "고객 상품 정보 조회 Controller", description = "최저가 및 상품 정보 조회 API")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/min-price")
    @Operation(summary = "카테고리 별 최저가 브랜드", description = "카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    public ResponseEntity<ProductResponse> getMinPricesByCategory() {
        return ResponseEntity.ok(productService.getMinPriceByCategory());
    }

    @GetMapping("/min-price-brand")
    @Operation(summary = "단일 브랜드 최저가", description = "단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    public ResponseEntity<MinPriceBrandResponse> viewMinPriceBrandForAllCategories() {
        return ResponseEntity.ok(productService.getMinPriceBrandForAllCategories());
    }

    @GetMapping("/min-max-price-category")
    @Operation(summary = "특정 카테고리 최저가/최고가 브랜드", description = "- 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    public ResponseEntity<MinMaxPriceResponse> getMinMaxPriceBrandsByCategory(@RequestParam("categoryName") String categoryName) {
        return ResponseEntity.ok(productService.getMinMaxPriceBrandsByCategory(categoryName));
    }
}