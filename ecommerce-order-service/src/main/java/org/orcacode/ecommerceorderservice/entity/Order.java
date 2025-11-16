package org.orcacode.ecommerceorderservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Entity
@Table
public class Order {

    @Id
    @Column(unique = true, nullable = false, updatable = false,name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private UUID user_id;
    @Column(nullable = false)
    private Float total_price;
    @Column(nullable = false)
    private String order_status;
    @Column(nullable = false)
    private LocalDate order_date;

    public Order(UUID id, UUID user_id, Float total_price, String order_status, LocalDate order_date) {
        this.id = id;
        this.user_id = user_id;
        this.total_price = total_price;
        this.order_status = order_status;
        this.order_date = order_date;
    }

    public Order() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }
}
