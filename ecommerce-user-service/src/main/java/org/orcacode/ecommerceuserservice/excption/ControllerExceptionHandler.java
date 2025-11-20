package org.orcacode.ecommerceuserservice.excption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * RestApi Handling / Rise error to consumers and services caller
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/9/2025
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
//    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {
//        logger.error("BusinessException occurred: {}", ex.getMessage());
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ex.getMessage());
    }
}
