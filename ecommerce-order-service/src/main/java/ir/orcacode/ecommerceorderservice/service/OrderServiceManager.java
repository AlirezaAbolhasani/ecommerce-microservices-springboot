package ir.orcacode.ecommerceorderservice.service;

import ir.orcacode.ecommerceorderservice.entity.OrderItems;
import org.modelmapper.ModelMapper;
import ir.orcacode.ecommerceorderservice.dto.OrderDto;
import ir.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import ir.orcacode.ecommerceorderservice.entity.Order;
import ir.orcacode.ecommerceorderservice.exception.OrderBusinessesException;
import ir.orcacode.ecommerceorderservice.messages.Messages;
import ir.orcacode.ecommerceorderservice.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class OrderServiceManager {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceManager(OrderService orderService, OrderItemService orderItemService,ModelMapper modelMapper) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public OrderModel getOrderInformationByOrderId(Long orderId) {
        if (orderId == null) {
            throw new OrderBusinessesException(HttpStatus.BAD_REQUEST, Messages.ORDER_BAD_REQUEST);
        } else {
            OrderDto orderDto = orderService.getOrderById(orderId);
            List<OrderItemsDto> orderItemsDtoList = orderItemService.findOrderItemsByOrderId(orderId);
            OrderModel orderModel = new OrderModel();
//            orderModel.setOrder(modelMapper.map(orderDto, OrderDto.class));
//            orderModel.setOrderItems(orderItemsDtoList.stream().map(orderItem -> modelMapper.map(orderItem, OrderItemsDto.class)).collect(Collectors.toList()));
            return orderModel;
        }
    }

    @Transactional
    public OrderModel saveOrder(OrderModel orderModel) {
        OrderDto orderDto = modelMapper.map(orderModel.getOrder(), OrderDto.class);
        OrderItemsDto orderItemsDto= new OrderItemsDto();
        List<OrderItemsDto> orderItemsList = new ArrayList<OrderItemsDto>();
        orderDto = orderService.createOrder(orderDto);
        orderModel.setOrder(orderDto);
        for (OrderItemsDto orderItemDto : orderModel.getOrderItems()) {
            orderItemDto=orderItemService.addOrderItem(orderItemDto);
            orderItemsList.add(modelMapper.map(orderItemDto, OrderItemsDto.class));
        }
        return orderModel;
    }



}
