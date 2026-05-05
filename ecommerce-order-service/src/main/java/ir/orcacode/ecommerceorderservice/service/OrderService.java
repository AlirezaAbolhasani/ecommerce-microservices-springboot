package ir.orcacode.ecommerceorderservice.service;

import ir.orcacode.ecommerceorderservice.dto.OrderDto;
import ir.orcacode.ecommerceorderservice.exception.OrderBusinessesException;
import ir.orcacode.ecommerceorderservice.mapper.OrderMapper;
import ir.orcacode.ecommerceorderservice.entity.Order;
import ir.orcacode.ecommerceorderservice.messages.Messages;
import ir.orcacode.ecommerceorderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository repository, OrderMapper orderMapper) {
        this.orderRepository = repository;
        this.orderMapper = orderMapper;
    }
    @Transactional
    public OrderDto getOrderById(Long id) {
        OrderDto orderDto= new OrderDto();
//        if (id == null) {
//            throw new OrderBusinessesException(HttpStatus.BAD_REQUEST, Messages.ORDER_BAD_REQUEST);
//        } else {
            orderDto = orderMapper.toDto(orderRepository.findById(id).orElseThrow(() -> new OrderBusinessesException(HttpStatus.NOT_FOUND, Messages.ORDER_NOT_FOUND)));
//        }
        return orderDto;
    }
    @Transactional
    public OrderDto createOrder(OrderDto dto) {
        Order orderEntity =orderRepository.save(orderMapper.toEntity(dto));
        //Logging Core
        return orderMapper.toDto(orderEntity);
    }
    @Transactional
    public OrderDto updateOrder(Long id, OrderDto dto) {
        Order order = orderMapper.toEntity(getOrderById(id));
        orderMapper.updateFromDto(dto,order);
        return orderMapper.toDto(orderRepository.save(order));
    }
    @Transactional
    public OrderDto removeOrder(Long id) {
        OrderDto orderDto = getOrderById(id);
        orderRepository.deleteById(id);
        return orderDto;
    }

}
