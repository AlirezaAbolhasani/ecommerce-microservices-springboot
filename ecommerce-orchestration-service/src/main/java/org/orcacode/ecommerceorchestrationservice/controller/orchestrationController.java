package org.orcacode.ecommerceorchestrationservice.controller;

import org.orcacode.ecommerceorchestrationservice.service.OrchestrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/20/2025
 */
@RestController
@RequestMapping(path = "/api/v1" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class orchestrationController {
    private final OrchestrationService orchestrationService;
    public orchestrationController(OrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }
    @GetMapping(path = "/users/{a}")
    public ResponseEntity<String> getById(String a){
        return new ResponseEntity<>( orchestrationService.getList(), HttpStatus.OK);
    }
}
