package musinsa.test.codi.admin.service;

import musinsa.test.codi.admin.mapper.AdminProductMapper;
import musinsa.test.codi.admin.request.ProductRequest;
import musinsa.test.codi.admin.response.AdminResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


class AdminProductServiceTest {

    @Mock
    private AdminProductMapper adminProductMapper;

    @InjectMocks
    private AdminProductService adminProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 상품_추가_테스트() {
        // given
        ProductRequest productRequest = new ProductRequest();
        productRequest.setBrandId(1L);
        productRequest.setCategoryId(1L);
        productRequest.setPrice(10000);

        // when
        AdminResponse response = adminProductService.addProduct(productRequest);

        // then
        verify(adminProductMapper, times(1)).insertProduct(productRequest);
        assertTrue(response.isSuccess());
    }

    @Test
    void 상품_수정_테스트() {
        // given
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductId(1L);
        productRequest.setBrandId(1L);
        productRequest.setCategoryId(1L);
        productRequest.setPrice(15000);

        // when
        AdminResponse response = adminProductService.updateProduct(productRequest);

        // then
        verify(adminProductMapper, times(1)).updateProduct(productRequest);
        assertTrue(response.isSuccess());
    }

    @Test
    void 상품_삭제_테스트() {
        // given
        Long productId = 1L;

        // when
        AdminResponse response = adminProductService.deleteProduct(productId);

        // then
        verify(adminProductMapper, times(1)).deleteProduct(productId);
        assertTrue(response.isSuccess());
    }
}