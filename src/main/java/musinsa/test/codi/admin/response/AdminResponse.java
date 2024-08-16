package musinsa.test.codi.admin.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminResponse {
    private boolean success;
    private String message;
    private Long id;
}
