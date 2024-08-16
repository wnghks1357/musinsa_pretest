package musinsa.test.codi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "무신사 코디 서비스",
                description = "코디 서비스",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/api/**"};
        String[] packagesToScan = {"musinsa.test.codi.admin.controller", "musinsa.test.codi.customer.controller"};

        return GroupedOpenApi.builder()
                .group("Codi Service API v1")
                .pathsToMatch(paths)
                .packagesToScan(packagesToScan)
                .build();
    }
}