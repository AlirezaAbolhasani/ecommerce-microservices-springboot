package org.orcacode.ecommercepaymentservice.exception;

import org.springframework.http.HttpStatus;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */

public class BusinessesException extends RuntimeException {
    private HttpStatus status;
    private String message;
    public BusinessesException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
