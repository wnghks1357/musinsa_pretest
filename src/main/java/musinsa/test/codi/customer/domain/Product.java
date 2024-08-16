package musinsa.test.codi.customer.domain;

import lombok.Data;

@Data
public class Product {
    private Long productId;
    private int price;
    private Brand brand;
    private Category category;
}
