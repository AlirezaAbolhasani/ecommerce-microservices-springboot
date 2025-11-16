package org.orcacode.ecommerceorderservice.repository;

import org.orcacode.ecommerceorderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
