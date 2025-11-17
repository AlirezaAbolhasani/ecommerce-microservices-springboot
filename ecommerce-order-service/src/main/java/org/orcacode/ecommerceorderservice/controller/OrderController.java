package org.orcacode.ecommerceorderservice.controller;


import org.orcacode.ecommerceorderservice.model.OrderModel;
import org.orcacode.ecommerceorderservice.service.OrderServiceManager;
import org.springframework.web.bind.annotation.*;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8084")
@RequestMapping("/api")
public class OrderController {

    private final OrderServiceManager orderServiceManager;

    private OrderController(OrderServiceManager orderServiceManager) {
        this.orderServiceManager = orderServiceManager;
    }

    @GetMapping("orders/{id}")
    public OrderModel showOrderInformation(@PathVariable(required = true) Long id) {
        return orderServiceManager.getOrderInformationByOrderId(id);
    }

    @PostMapping("orders/")
    public OrderModel addOrder(@RequestBody(required = true) OrderModel orderModel) {

    }

}
