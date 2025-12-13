package org.orcacode.ecommerceorderservice.repository;

import org.orcacode.ecommerceorderservice.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    @Query(nativeQuery = true , value = "select oi.* from public.ec_order_items oi where oi.order_id = :order_id")
    public List<OrderItems> findByOrderId(@Param(value = "order_id") Long orderId);
}
