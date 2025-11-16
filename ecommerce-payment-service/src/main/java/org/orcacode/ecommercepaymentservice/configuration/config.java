package org.orcacode.ecommercepaymentservice.configuration;

import org.mapstruct.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@Configuration
public class config {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
