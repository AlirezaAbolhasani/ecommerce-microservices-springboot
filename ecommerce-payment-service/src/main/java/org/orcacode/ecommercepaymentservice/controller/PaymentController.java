package org.orcacode.ecommercepaymentservice.controller;

import org.modelmapper.ModelMapper;
import org.orcacode.ecommercepaymentservice.dto.PaymentMapper;
import org.orcacode.ecommercepaymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@CrossOrigin(origins = "http://127.0.0.1:8083")
@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper peymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper peymentMapper) {
        this.paymentService = paymentService;
        this.peymentMapper = peymentMapper;
    }


}
