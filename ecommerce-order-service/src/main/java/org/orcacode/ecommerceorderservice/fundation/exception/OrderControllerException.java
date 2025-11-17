package org.orcacode.ecommerceorderservice.fundation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
@RestControllerAdvice
public class OrderControllerException {
    //    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    @ExceptionHandler(OrderBusinessesException.class)
    public ResponseEntity<String> handleOrderBusinessesException(OrderBusinessesException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
