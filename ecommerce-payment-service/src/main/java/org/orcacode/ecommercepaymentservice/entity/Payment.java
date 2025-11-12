package org.orcacode.ecommercepaymentservice.entity;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Entity
@Table
public class Payment {
    @Id

    private Long id;
    private String paymentId;
    private String customerId;
    private Date date;
    private String status;
    private UUID orderId;
    private UUID productId;
    private UUID provider_txn_id;


}
