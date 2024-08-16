package musinsa.test.codi.customer.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import musinsa.test.codi.customer.dto.CategoryPriceDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class MinPriceBrandResponse {

    @JsonProperty("최저가")
    private BrandDetail brandDetail;

    @Data
    @AllArgsConstructor
    public static class BrandDetail {
        @JsonProperty("브랜드")
        private String brandName;

        @JsonProperty("카테고리")
        private List<CategoryPriceDTO> categoryPrices;

        @JsonProperty("총액")
        private String totalPrice;
    }
}