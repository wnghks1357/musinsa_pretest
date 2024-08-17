package musinsa.test.codi.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productId;
    private int price;
    private Brand brand;
    private Category category;
}
