package com.techlab.vaccinationcenter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public static OpenAPI openAPIMetaInfo() {
        return new OpenAPI()
                .info(new Info().title("API Documentation Vaccination Center")
                        .description("API developer portal documentation for Vaccination Center")
                        .version("v1"));
    }
}
