package ir.orcacode.ecommerceorderservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import ir.orcacode.ecommerceorderservice.infrastructure.audit.AuditService;
import ir.orcacode.ecommerceorderservice.infrastructure.audit.OrcaRequestHeaderInfo;
import ir.orcacode.ecommerceorderservice.infrastructure.meta.GeneratedBy;
import ir.orcacode.ecommerceorderservice.model.OrderModel;
import ir.orcacode.ecommerceorderservice.service.OrderService;
import ir.orcacode.ecommerceorderservice.service.OrderServiceManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@GeneratedBy(value = "OrcaCodeServiceGenerator",version = "1.0.1",module = "Order",description = "")
@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final AuditService adtLog;
    private final OrderServiceManager orderServiceManager;
    private final OrderService orderService;
    public OrderController(OrderServiceManager orderServiceManager,OrderService orderService,
    AuditService adtService) {
        this.orderServiceManager = orderServiceManager;
        this.orderService = orderService;
        this.adtLog=adtService;
    }

    @GetMapping("/orders/{id}")
    @Operation(summary = "Find a user by userID. This number is unique and personally.",
            description = "Id must exist")
    public ResponseEntity<OrderModel> showOrderInformation(@PathVariable(required = true) Long id,
                                                           HttpServletRequest request) {
        OrcaRequestHeaderInfo orcaRequestHeaderInfo = new OrcaRequestHeaderInfo();
        log.info("Username={} action=GET_INFORMATION id={}", orcaRequestHeaderInfo.getUsernameFromRequest(request,"X-Username"),id);
        return new ResponseEntity<>(orderServiceManager.getOrderInformationByOrderId(id), HttpStatus.OK);
    }

    @PostMapping("/orders")
    @Operation(summary = "Find a user by userID. This number is unique and personally.",
            description = "Id must exist")
    public ResponseEntity<OrderModel> addOrder(@Valid @RequestBody(required = true) OrderModel orderModel,
                                               HttpServletRequest request) {
        OrcaRequestHeaderInfo orcaRequestHeaderInfo = new OrcaRequestHeaderInfo();
        String user = orcaRequestHeaderInfo.getUsernameFromRequest(request,"X-Username");
        log.info("Username={} action=CREATE_PRODUCT name={}",user,orderModel.getOrder().getId());
        var result=  orderServiceManager.saveOrder(orderModel);
        adtLog.log(user,getClass().getName(), OrderModel.class.getName(),orderModel.getOrder().getId(),"***");
        log.info("User={} action=CREATE_PRODUCT_SUCCESS id={}",user,result.getOrder().getId());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
