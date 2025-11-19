package org.orcacode.ecommerceorderservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.orcacode.ecommerceorderservice.dto.OrderDto;
import org.orcacode.ecommerceorderservice.model.OrderModel;
import org.orcacode.ecommerceorderservice.service.OrderService;
import org.orcacode.ecommerceorderservice.service.OrderServiceManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderServiceManager orderServiceManager;
    private final OrderService orderService;

    public OrderController(OrderServiceManager orderServiceManager,OrderService orderService) {
        this.orderServiceManager = orderServiceManager;
        this.orderService = orderService;
    }

    @GetMapping("orders/{id}")
    @Operation(summary = "Find a user by userID. This number is unique and personally.",
            description = "Id must exist")
    public ResponseEntity<OrderModel> showOrderInformation(@PathVariable(required = true) Long id) {
        return new ResponseEntity<>(orderServiceManager.getOrderInformationByOrderId(id), HttpStatus.OK);
    }

    @PostMapping("orders/")
    @Operation(summary = "Find a user by userID. This number is unique and personally.",
            description = "Id must exist")
    public ResponseEntity<OrderModel> addOrder(@RequestBody(required = true) OrderModel orderModel) {
        return new ResponseEntity<>(orderServiceManager.saveOrder(orderModel), HttpStatus.CREATED);
    }

    @GetMapping("orders/{id}")
    @Operation(summary = "Find a user by userID. This number is unique and personally.",
            description = "Id must exist")
    public ResponseEntity<OrderDto> getOrder(@PathVariable(required = true) Long id) {
       return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

}
