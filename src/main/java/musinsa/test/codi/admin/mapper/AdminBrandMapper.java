package musinsa.test.codi.admin.mapper;

import musinsa.test.codi.admin.request.BrandRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminBrandMapper {

    void insertBrand(BrandRequest brandRequest);

    void updateBrand(BrandRequest brandRequest);

    void deleteBrand(Long brandId);

}