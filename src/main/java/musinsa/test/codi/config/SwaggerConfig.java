//package musinsa.test.codi.config;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
//import lombok.RequiredArgsConstructor;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@OpenAPIDefinition(
//        info = @Info(title = "IP 대역 관리",
//                description = "IP 대역 관리 api명세",
//                version = "v1"))
//@RequiredArgsConstructor
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public GroupedOpenApi chatOpenApi() {
//        String[] paths = {"/api/**"};
//        String[] packagesToScan = {"com.musinsa.test.codi.controller"};
//
//        return GroupedOpenApi.builder()
//                .group("IP Management API v1")
//                .pathsToMatch(paths)
//                .packagesToScan(packagesToScan)
//                .build();
//    }
//}