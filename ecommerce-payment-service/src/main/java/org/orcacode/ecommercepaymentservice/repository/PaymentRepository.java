package org.orcacode.ecommercepaymentservice.repository;

import org.orcacode.ecommercepaymentservice.entity.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    Page<PaymentEntity> findAll(Pageable pageable);
}
