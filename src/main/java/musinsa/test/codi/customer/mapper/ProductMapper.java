package musinsa.test.codi.customer.mapper;

import musinsa.test.codi.customer.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> findAllProducts();

}
