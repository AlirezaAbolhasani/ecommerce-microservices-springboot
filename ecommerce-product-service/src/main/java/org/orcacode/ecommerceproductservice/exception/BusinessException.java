package org.orcacode.ecommerceproductservice.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/10/2025
 */
public class BusinessException extends RuntimeException {
    private HttpStatus status;
    private String message;
    private Date timestamp;

    public BusinessException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
