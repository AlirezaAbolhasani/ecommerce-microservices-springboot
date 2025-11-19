package org.orcacode.ecommerceorderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Entity
@Table(name = "ec_order",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @Column(unique = true, nullable = false, updatable = false,name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = false , nullable = false)
    private UUID user_id;
    @Column(unique = false , nullable = false)
    private Float total_price;
    @Column(unique = false , nullable = false)
    private String order_status;
    @Column(unique = false , nullable = false)
    private LocalDate order_date;

}
