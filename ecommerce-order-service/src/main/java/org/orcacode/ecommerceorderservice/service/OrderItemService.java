package org.orcacode.ecommerceorderservice.service;

import org.orcacode.ecommerceorderservice.dto.OrderItemsMapper;
import org.orcacode.ecommerceorderservice.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
@Service
public class OrderItemService {
    private final OrderItemsRepository orderItemsRepository;
    private final OrderItemsMapper orderItemsMapper;

    @Autowired
    public OrderItemService(OrderItemsRepository orderItemsRepository, OrderItemsMapper orderItemsMapper) {
        this.orderItemsRepository = orderItemsRepository;
        this.orderItemsMapper = orderItemsMapper;
    }

}
