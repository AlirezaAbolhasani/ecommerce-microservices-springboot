package org.orcacode.ecommerceorderservice.model;

import org.orcacode.ecommerceorderservice.entity.Order;
import org.orcacode.ecommerceorderservice.entity.OrderItems;

import java.util.List;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/16/2025
 */
public class OrderModel {
    private Order order;
    private List<OrderItems> orderItems;
    public OrderModel(Order order, List<OrderItems> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }

    public OrderModel() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}
