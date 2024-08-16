package musinsa.test.codi.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductInfoDTO {
    private String categoryName;
    private String brandName;
    private int price;
}
