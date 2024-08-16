package musinsa.test.codi.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import musinsa.test.codi.customer.dto.ProductInfoDTO;

import java.util.List;

@AllArgsConstructor
@Data
public class ProductResponse {
    private List<ProductInfoDTO> productInfoDTOList;
    private int totalProductPrice;
}
