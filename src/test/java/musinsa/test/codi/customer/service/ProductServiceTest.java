package musinsa.test.codi.customer.service;

import musinsa.test.codi.customer.domain.Brand;
import musinsa.test.codi.customer.domain.Category;
import musinsa.test.codi.customer.domain.Product;
import musinsa.test.codi.customer.mapper.ProductMapper;
import musinsa.test.codi.customer.response.MinMaxPriceResponse;
import musinsa.test.codi.customer.response.MinPriceBrandResponse;
import musinsa.test.codi.customer.response.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void 카테고리별_최저가_상품_조회() {
        // given
        List<Product> products = new ArrayList<>();
        // Mock 데이터 생성
        products.add(new Product(1L, 10000, new Brand(1L, "A"), new Category(1L, "상의")));
        products.add(new Product(2L, 20000, new Brand(2L, "B"), new Category(1L, "상의")));

        when(productMapper.findAllProducts()).thenReturn(products);

        // when
        ProductResponse response = productService.getMinPriceByCategory();

        // then
        verify(productMapper, times(1)).findAllProducts();
        assertEquals(1, response.getProductInfoDTOList().size());
        assertEquals(10000, response.getTotalProductPrice());
    }

    @Test
    void 모든_카테고리_최저가_브랜드_조회() {
        // given
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L,10000, new Brand(1L, "Brand A"), new Category(1L, "상의")));
        products.add(new Product(2L, 20000, new Brand(2L, "Brand B"), new Category(2L, "바지")));

        when(productMapper.findAllProducts()).thenReturn(products);

        // when
        MinPriceBrandResponse response = productService.getMinPriceBrandForAllCategories();

        // then
        verify(productMapper, times(1)).findAllProducts();
        assertEquals("Brand A", response.getBrandDetail().getBrandName());
        assertEquals("10,000", response.getBrandDetail().getTotalPrice());
    }

    @Test
    void 특정_카테고리_최저가_및_최고가_브랜드_조회() {
        // given
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, 10000, new Brand(1L, "Brand A"), new Category(1L, "상의")));
        products.add(new Product(2L, 20000, new Brand(2L, "Brand B"), new Category(1L, "상의")));

        when(productMapper.findAllProducts()).thenReturn(products);

        // when
        MinMaxPriceResponse response = productService.getMinMaxPriceBrandsByCategory("상의");

        // then
        verify(productMapper, times(1)).findAllProducts();
        assertEquals("상의", response.getCategory());
        assertEquals(1, response.getMinPrice().size());
        assertEquals(1, response.getMaxPrice().size());
        assertEquals("Brand A", response.getMinPrice().get(0).getBrand());
        assertEquals("Brand B", response.getMaxPrice().get(0).getBrand());
    }
}