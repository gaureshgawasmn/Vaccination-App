package com.techlab.citizenservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public static OpenAPI openAPIMetaInfo() {
        return new OpenAPI()
                .info(new Info().title("API documentation for Citizen Service")
                        .description("API developer portal documentation for Citizen Service")
                        .version("v1"));
    }
}
