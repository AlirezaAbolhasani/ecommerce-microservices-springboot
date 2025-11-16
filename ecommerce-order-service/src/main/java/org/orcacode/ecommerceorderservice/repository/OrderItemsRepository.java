package org.orcacode.ecommerceorderservice.repository;

import org.orcacode.ecommerceorderservice.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
