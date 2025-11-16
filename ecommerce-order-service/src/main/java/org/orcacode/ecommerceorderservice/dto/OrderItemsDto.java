package org.orcacode.ecommerceorderservice.dto;

import java.math.BigDecimal;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
public class OrderItemsDto {
    private Long id;
    private Long order_id; // REFERENCES orders(id),
    private Long product_id;
    private String product_name; //SnapShot of name purchaseTime
    private BigDecimal product_price; //Snapshot from price in purchaseTime
    private Integer quantity;
}
