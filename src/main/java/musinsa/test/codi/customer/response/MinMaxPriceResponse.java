package musinsa.test.codi.customer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import musinsa.test.codi.customer.dto.BrandPriceDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class MinMaxPriceResponse {

    @JsonProperty("카테고리")
    private String category;

    @JsonProperty("최저가")
    private List<BrandPriceDTO> minPrice;

    @JsonProperty("최고가")
    private List<BrandPriceDTO> maxPrice;
}
