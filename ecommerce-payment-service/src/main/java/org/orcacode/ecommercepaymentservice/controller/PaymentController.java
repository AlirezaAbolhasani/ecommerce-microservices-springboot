package org.orcacode.ecommercepaymentservice.controller;

import org.modelmapper.ModelMapper;
import org.orcacode.ecommercepaymentservice.dto.PaymentDto;
import org.orcacode.ecommercepaymentservice.dto.PaymentMapper;
import org.orcacode.ecommercepaymentservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("payments/{id}")
    public ResponseEntity<PaymentDto> getPaymentService(@PathVariable long id) {
        return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

}
