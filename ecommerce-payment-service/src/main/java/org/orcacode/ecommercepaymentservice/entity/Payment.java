package org.orcacode.ecommercepaymentservice.entity;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.UUID;

@Entity
@Table
public class Payment {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false , precision = 2)
    private Short status;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false , scale = 4 , precision = 19)
    private BigDecimal amount;

    @Column(nullable = false)
    private Currency currency;

    @Column(nullable = false)
    private LocalDate paymentDate;
}
