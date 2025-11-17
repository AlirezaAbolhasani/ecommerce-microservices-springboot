package org.orcacode.ecommerceorderservice.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@Entity
@Table(name = "ec_order_items",schema = "public")
public class OrderItems {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = false,nullable = false)
    private Long order_id; // REFERENCES orders(id),
    @Column(unique = false , nullable = false)
    private Long product_id;
    @Column(unique = false , nullable = false)
    private String product_name; //SnapShot of name purchaseTime
    @Column(nullable = false)
    private BigDecimal product_price; //Snapshot from price in purchaseTime
    @Column(nullable = false)
    private Integer quantity;

    public OrderItems() {
    }

    public OrderItems(Long id, Long order_id, Long product_id, String product_name, BigDecimal product_price, Integer quantity) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
