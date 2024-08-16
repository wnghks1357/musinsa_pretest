package musinsa.test.codi.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BrandPriceDTO {
    @JsonProperty("브랜드")
    private String brand;

    @JsonProperty("가격")
    private String price;
}
