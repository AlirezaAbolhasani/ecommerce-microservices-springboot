package org.orcacode.ecommerceorderservice.enumeration;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
public enum OrderStatus {
    NEW(1, "New"),
    IN_PROGRESS(2, "In progress"),
    COMPLETED(3, "Completed"),
    CANCELLED(4, "Cancelled");

    private int code;
    private String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
