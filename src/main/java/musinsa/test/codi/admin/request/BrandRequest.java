package musinsa.test.codi.admin.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  // null이 아닌 필드만 포함
public class BrandRequest {

    @Schema(description = "브랜드 ID (브랜드 수정 시에만 필요)", example = "1", required = false)
    private Long brandId;

    @Schema(description = "브랜드명", example = "J")
    private String brandName;
}
