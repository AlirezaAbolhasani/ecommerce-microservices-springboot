package org.orcacode.ecommerceorderservice.model;

import org.orcacode.ecommerceorderservice.dto.OrderDto;
import org.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import org.orcacode.ecommerceorderservice.entity.Order;
import org.orcacode.ecommerceorderservice.entity.OrderItems;

import java.util.List;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
public class OrderModel {
    private OrderDto order;
    private List<OrderItemsDto> orderItems;
    public OrderModel(OrderDto order, List<OrderItemsDto> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }

    public OrderModel() {
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public List<OrderItemsDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsDto> orderItems) {
        this.orderItems = orderItems;
    }
}
