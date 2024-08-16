package musinsa.test.codi.admin.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequest {

    @Schema(description = "상품 ID (상품 수정 시에만 필요)", example = "1", required = false)
    private Long productId;

    @Schema(description = "브랜드 ID", example = "1")
    private Long brandId;

    @Schema(description = "카테고리 ID", example = "1")
    private Long categoryId;

    @Schema(description = "상품 가격", example = "10000")
    private int price;
}
