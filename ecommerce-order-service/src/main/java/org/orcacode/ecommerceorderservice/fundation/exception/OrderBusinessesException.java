package org.orcacode.ecommerceorderservice.fundation.exception;

import org.springframework.http.HttpStatusCode;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */

public class OrderBusinessesException extends RuntimeException{
    private HttpStatusCode code;
    private String message;

    public OrderBusinessesException(HttpStatusCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatusCode getCode() {
        return code;
    }

    public void setCode(HttpStatusCode code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
