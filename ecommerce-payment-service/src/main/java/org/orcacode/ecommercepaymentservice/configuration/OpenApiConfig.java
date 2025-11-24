package org.orcacode.ecommercepaymentservice.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/20/2025
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Orders Information")
                        .version("1.0")
                        .description("Product API documentation for my Spring Boot app")
                        .contact(new Contact()
                                .name("Alireza")
                                .email("alireza.1111@gmail.com")));
    }

}