package org.orcacode.ecommercepaymentservice.controller;

import org.modelmapper.ModelMapper;
import org.orcacode.ecommercepaymentservice.dto.PaymentDto;
import org.orcacode.ecommercepaymentservice.dto.PaymentMapper;
import org.orcacode.ecommercepaymentservice.service.PaymentService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<PaymentDto> getByPaymentId(@RequestParam(defaultValue = "0") long id) {
        return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
    }
    @GetMapping("/payments")
    public ResponseEntity<Page<PaymentDto>> getPaymentByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(paymentService.getPayment(page, size),HttpStatus.OK);
    }
    @PostMapping("/payments")
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentService.savePayment(paymentDto), HttpStatus.CREATED);
    }
    @PutMapping("/payments")
    public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentDto dto) {
        return new ResponseEntity<>(paymentService.updatePayment(dto),HttpStatus.CREATED);
    }
    @DeleteMapping("/payments")
    public ResponseEntity<PaymentDto> deletePayment(@RequestBody Long id) {
        return new ResponseEntity<>(paymentService.deletePayment(id),HttpStatus.OK);
    }
}
