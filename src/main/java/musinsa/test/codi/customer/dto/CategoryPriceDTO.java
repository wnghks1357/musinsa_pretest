package musinsa.test.codi.customer.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryPriceDTO {

    @JsonProperty("카테고리")
    private String categoryName;

    @JsonProperty("가격")
    private String price;
}