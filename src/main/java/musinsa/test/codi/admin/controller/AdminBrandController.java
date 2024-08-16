package musinsa.test.codi.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import musinsa.test.codi.admin.request.BrandRequest;
import musinsa.test.codi.admin.response.AdminResponse;
import musinsa.test.codi.admin.service.AdminBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/admin/brand")
@RequiredArgsConstructor
@Tag(name = "Admin Brand Controller", description = "Admin 브랜드 정보 관리 API")
public class AdminBrandController {

    private final AdminBrandService adminBrandService;

    @PostMapping
    @Operation(summary = "브랜드 추가", description = "신규 브랜드 추가")
    public ResponseEntity<AdminResponse> addBrand(@RequestBody BrandRequest brandRequest) {
        return ResponseEntity.ok(adminBrandService.addBrand(brandRequest));
    }

    @PutMapping
    @Operation(summary = "브랜드 수정", description = "브랜드 정보 수정")
    public ResponseEntity<AdminResponse> updateBrand(@RequestBody BrandRequest brandRequest) {
        return ResponseEntity.ok(adminBrandService.updateBrand(brandRequest));
    }

    @DeleteMapping("/{brandId}")
    @Operation(summary = "브랜드 삭제", description = "브랜드 정보 삭제")
    public ResponseEntity<AdminResponse> deleteBrand(@PathVariable(name = "brandId") Long brandId) {
        return ResponseEntity.ok(adminBrandService.deleteBrand(brandId));
    }
}