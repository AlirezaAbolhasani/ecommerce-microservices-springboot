package org.orcacode.ecommercepaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@ComponentScan(basePackages = "org.orcacode.ecommercepaymentservice.dto")
public class EcommercePaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommercePaymentServiceApplication.class, args);
    }

}
