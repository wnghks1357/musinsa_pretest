package musinsa.test.codi.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import musinsa.test.codi.admin.mapper.AdminBrandMapper;
import musinsa.test.codi.admin.mapper.AdminProductMapper;
import musinsa.test.codi.admin.request.BrandRequest;
import musinsa.test.codi.admin.request.ProductRequest;
import musinsa.test.codi.admin.response.AdminResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminProductService {

	private final AdminProductMapper adminProductMapper;

	public AdminResponse addProduct(ProductRequest productRequest) {
		adminProductMapper.insertProduct(productRequest);
		Long productId = productRequest.getProductId();
		return new AdminResponse(true, "상품 추가 성공", productId);
	}

	public AdminResponse updateProduct(ProductRequest productRequest) {
		adminProductMapper.updateProduct(productRequest);
		return new AdminResponse(true, "상품 업데이트 성공", productRequest.getProductId());
	}

	public AdminResponse deleteProduct(Long productId) {
		adminProductMapper.deleteProduct(productId);
		return new AdminResponse(true, "상품 삭제 성공", productId);
	}
}