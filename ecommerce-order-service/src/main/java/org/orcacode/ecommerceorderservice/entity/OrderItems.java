package org.orcacode.ecommerceorderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@Entity
@Table(name = "ec_order_items",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
}
