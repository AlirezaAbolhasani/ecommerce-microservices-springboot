package org.orcacode.ecommerceuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableCircuitBreaker

@EnableFeignClients
@SpringBootApplication
public class EcommerceUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceUserServiceApplication.class, args);
	}

}
