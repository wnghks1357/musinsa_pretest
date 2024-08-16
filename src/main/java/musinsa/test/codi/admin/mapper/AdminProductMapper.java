package musinsa.test.codi.admin.mapper;

import musinsa.test.codi.admin.request.ProductRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminProductMapper {

    void insertProduct(ProductRequest productRequest);

    void updateProduct(ProductRequest productRequest);

    void deleteProduct(Long productId);

}