package org.orcacode.ecommerceorderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
@Component
public class OrderServiceManager {
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @Autowired
    public OrderServiceManager(OrderService orderService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }


}
