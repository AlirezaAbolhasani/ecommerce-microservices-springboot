package org.orcacode.ecommercepaymentservice.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
public class PaymentDto {
    private Long id;
    private Long orderId;
    private UUID userId;
    private LocalDate date;
    private String status;
    private Long productId;
    private BigDecimal amount;
    private Currency currency;
    private LocalDate paymentDate;

    public PaymentDto() {
    }

    public PaymentDto(Long id, Long orderId, UUID userId, LocalDate date, String status, Long productId, BigDecimal amount, Currency currency, LocalDate paymentDate) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.date = date;
        this.status = status;
        this.productId = productId;
        this.amount = amount;
        this.currency = currency;
        this.paymentDate = paymentDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
