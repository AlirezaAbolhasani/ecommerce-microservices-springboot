package org.orcacode.ecommerceproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.orcacode.ecommerceproductservice.dto")
public class EcommerceProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceProductServiceApplication.class, args);
    }

}
