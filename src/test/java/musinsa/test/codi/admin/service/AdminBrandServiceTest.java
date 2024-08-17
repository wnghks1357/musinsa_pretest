package musinsa.test.codi.admin.service;

import musinsa.test.codi.admin.mapper.AdminBrandMapper;
import musinsa.test.codi.admin.request.BrandRequest;
import musinsa.test.codi.admin.response.AdminResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AdminBrandServiceTest {
    @Mock
    private AdminBrandMapper adminBrandMapper;

    @InjectMocks
    private AdminBrandService adminBrandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 브랜드_추가_테스트() {
        // given
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setBrandName("New Brand");

        // when
        AdminResponse response = adminBrandService.addBrand(brandRequest);

        // then
        verify(adminBrandMapper, times(1)).insertBrand(brandRequest);
        assertTrue(response.isSuccess());
    }

    @Test
    void 브랜드_수정_테스트() {
        // given
        BrandRequest brandRequest = new BrandRequest();
        brandRequest.setBrandId(1L);
        brandRequest.setBrandName("Updated Brand");

        // when
        AdminResponse response = adminBrandService.updateBrand(brandRequest);

        // then
        verify(adminBrandMapper, times(1)).updateBrand(brandRequest);
        assertTrue(response.isSuccess());
        assertEquals(1L, response.getId());
    }

    @Test
    void 브랜드_삭제_테스트() {
        // given
        Long brandId = 1L;

        // when
        AdminResponse response = adminBrandService.deleteBrand(brandId);

        // then
        verify(adminBrandMapper, times(1)).deleteBrand(brandId);
        assertTrue(response.isSuccess());
    }
}
