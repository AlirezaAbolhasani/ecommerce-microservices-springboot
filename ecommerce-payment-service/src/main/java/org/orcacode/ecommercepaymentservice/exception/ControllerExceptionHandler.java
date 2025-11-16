package org.orcacode.ecommercepaymentservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(BusinessesException.class)
    public ResponseEntity<String> handleBusinessesException(BusinessesException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
