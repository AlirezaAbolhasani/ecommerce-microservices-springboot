package org.orcacode.ecommerceorderservice.service;

import org.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import org.orcacode.ecommerceorderservice.mapper.OrderItemsMapper;
import org.orcacode.ecommerceorderservice.entity.OrderItems;
import org.orcacode.ecommerceorderservice.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<OrderItemsDto> findOrderItemsByOrderId(Long id) {
        List<OrderItems> orderItems = orderItemsRepository.findByOrderId(id);
        List<OrderItemsDto> orderItemsDtos = new ArrayList<>();
        for (OrderItems orderItem : orderItems) {
            orderItemsDtos.add(orderItemsMapper.toDto(orderItem));
        }
        return orderItemsDtos;
    }

    @Transactional
    public OrderItemsDto addOrderItem(OrderItemsDto dto) {
        return orderItemsMapper.toDto(orderItemsRepository.save(orderItemsMapper.toEntity(dto)));
    }
}
