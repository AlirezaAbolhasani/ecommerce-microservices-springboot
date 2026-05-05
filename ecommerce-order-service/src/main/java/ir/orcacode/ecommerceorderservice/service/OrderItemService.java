package ir.orcacode.ecommerceorderservice.service;

import ir.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import ir.orcacode.ecommerceorderservice.infrastructure.meta.GeneratedBy;
import ir.orcacode.ecommerceorderservice.mapper.OrderItemsMapper;
import ir.orcacode.ecommerceorderservice.entity.OrderItems;
import ir.orcacode.ecommerceorderservice.repository.OrderItemsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@GeneratedBy(value = "OrcaCodeServiceGenerator",version = "1.0",module ="OrderItem",description = "")
@Service
public class OrderItemService {
    private static final Logger logger = LoggerFactory.getLogger(OrderItemService.class);
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
        OrderItemsDto result =orderItemsMapper.toDto(orderItemsRepository.save(orderItemsMapper.toEntity(dto)));
        return result;
    }
}
