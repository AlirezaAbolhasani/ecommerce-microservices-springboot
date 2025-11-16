package org.orcacode.ecommerceorderservice.service;

import org.orcacode.ecommerceorderservice.dto.OrderDto;
import org.orcacode.ecommerceorderservice.dto.OrderMapper;
import org.orcacode.ecommerceorderservice.entity.Order;
import org.orcacode.ecommerceorderservice.exception.OrderBusinessesException;
import org.orcacode.ecommerceorderservice.messages.Messages;
import org.orcacode.ecommerceorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemServices;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository repository, OrderItemService orderItemServices, OrderMapper orderMapper) {
        this.orderRepository = repository;
        this.orderItemServices = orderItemServices;
        this.orderMapper = orderMapper;
    }
    @Transactional
    public OrderDto findById(Long id) {
        OrderDto orderDto;
        if (id == null) {
            throw new OrderBusinessesException(HttpStatus.BAD_REQUEST, Messages.ORDER_BAD_REQUEST);
        } else {
            orderDto = orderMapper.toDto(orderRepository.findById(id).orElseThrow(() -> new OrderBusinessesException(HttpStatus.NOT_FOUND, Messages.ORDER_NOT_FOUND)));
        }
        return orderDto;
    }
    @Transactional
    public OrderDto createOrder(OrderDto dto) {
        Order orderEntity =orderRepository.save(orderMapper.toEntity(dto));
        return orderMapper.toDto(orderEntity);
    }
    @Transactional
    public OrderDto updateOrder(Long id, OrderDto dto) {
        Order order = orderMapper.toEntity(findById(id));
        orderMapper.updateFromDto(dto,order);
        return orderMapper.toDto(orderRepository.save(order));
    }
    @Transactional
    public OrderDto removeOrder(Long id) {
        OrderDto orderDto = findById(id);
        orderRepository.deleteById(id);
        return orderDto;
    }

}
