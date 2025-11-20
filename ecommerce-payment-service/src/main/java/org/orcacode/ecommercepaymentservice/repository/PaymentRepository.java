package org.orcacode.ecommercepaymentservice.repository;

import org.orcacode.ecommercepaymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
