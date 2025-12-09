package org.orcacode.ecommercepaymentservice.entity;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ec_payment" , schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "gen_payment_seq" )
    @SequenceGenerator(name = "gen_payment_seq" , allocationSize = 1 , initialValue = 1 , schema = "public" , sequenceName = "payment_seq")
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

//    @Column(nullable = false)
//    private Currency currency;

    @Column(nullable = false)
    private LocalDate paymentDate;

}
