package org.orcacode.ecommerceuserservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@Configuration
@ComponentScan("org.orcacode.ecommerceuserservice.*")
public class Config {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
