package org.orcacode.ecommerceuserservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/26/2025
 */
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User. withUsername("alireza")
                .password("{noop}123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
