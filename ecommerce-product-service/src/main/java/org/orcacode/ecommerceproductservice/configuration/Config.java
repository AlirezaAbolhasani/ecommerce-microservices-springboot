package org.orcacode.ecommerceproductservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@Configuration
public class OrderConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
