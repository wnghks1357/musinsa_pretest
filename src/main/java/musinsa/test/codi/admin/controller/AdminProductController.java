package musinsa.test.codi.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import musinsa.test.codi.admin.request.ProductRequest;
import musinsa.test.codi.admin.response.AdminResponse;
import musinsa.test.codi.admin.service.AdminProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/admin/product")
@RequiredArgsConstructor
@Tag(name = "Admin Product Controller", description = "Admin 상품 정보 관리 API")
public class AdminProductController {

    private final AdminProductService adminProductService;

    @PostMapping
    @Operation(summary = "상품 추가", description = "신규 상품 추가")
    public ResponseEntity<AdminResponse> addProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(adminProductService.addProduct(productRequest));
    }

    @PutMapping
    @Operation(summary = "상품 수정", description = "상품 정보 수정")
    public ResponseEntity<AdminResponse> updateProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(adminProductService.updateProduct(productRequest));
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "상품 삭제", description = "상품 정보 삭제")
    public ResponseEntity<AdminResponse> deleteProduct(@PathVariable(name = "productId") Long productId) {
        return ResponseEntity.ok(adminProductService.deleteProduct(productId));
    }

}