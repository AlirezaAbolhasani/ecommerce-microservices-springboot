package org.orcacode.ecommercepaymentservice.enumeration;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
public enum PaymentEnumeration {
    Initialized(1, "Initialized"),
    Pending(2, "Pending"),
    Authorized(3, "Authorized"),
    Captured(4, "Captured"),
    Failed(5, "Failed"),
    Cancelled(6, "Cancelled"),
    Refunded(7, "Refunded"),
    Chargeback(8, "Chargeback");

    private int value;
    private String description;

    private PaymentEnumeration(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
