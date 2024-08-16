package musinsa.test.codi.admin.service;

import musinsa.test.codi.admin.mapper.AdminBrandMapper;
import musinsa.test.codi.admin.request.BrandRequest;
import musinsa.test.codi.admin.request.ProductRequest;
import musinsa.test.codi.admin.response.AdminResponse;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminBrandService {

	private final AdminBrandMapper adminBrandMapper;

	public AdminResponse addBrand(BrandRequest brandRequest) {
		adminBrandMapper.insertBrand(brandRequest);
		Long brandId = brandRequest.getBrandId();
		return new AdminResponse(true, "브랜드 추가 성공", brandId);
	}

	public AdminResponse updateBrand(BrandRequest brandRequest) {
		adminBrandMapper.updateBrand(brandRequest);
		return new AdminResponse(true, "브랜드 업데이트 성공", brandRequest.getBrandId());
	}

	public AdminResponse deleteBrand(Long brandId) {
		adminBrandMapper.deleteBrand(brandId);
		return new AdminResponse(true, "브랜드 삭제 성공", brandId);
	}
}