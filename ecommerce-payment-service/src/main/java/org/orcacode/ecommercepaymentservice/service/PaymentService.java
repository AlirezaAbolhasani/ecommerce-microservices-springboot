package org.orcacode.ecommercepaymentservice.service;

import org.modelmapper.ModelMapper;
import org.orcacode.ecommercepaymentservice.dto.PaymentDto;
import org.orcacode.ecommercepaymentservice.dto.PaymentMapper;
import org.orcacode.ecommercepaymentservice.entity.Payment;
import org.orcacode.ecommercepaymentservice.exception.BusinessesException;
import org.orcacode.ecommercepaymentservice.messages.Messages;
import org.orcacode.ecommercepaymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Service
public class PaymentService {
    private final PaymentRepository payRepo;
    private final PaymentMapper payMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper, ModelMapper modelMapper) {
        this.payRepo = paymentRepository;
        this.payMapper = paymentMapper;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public PaymentDto getPaymentById(Long id) {
        if (id != null) {
            return payMapper.toDto(payRepo.findById(id).orElseThrow(() -> new BusinessesException(HttpStatus.NOT_FOUND, Messages.PAYMENT_NOT_FOUND)));
        } else {
            throw new BusinessesException(HttpStatus.BAD_REQUEST, Messages.BAD_REQUEST);
        }
    }

    @Transactional
    public PaymentDto savePayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        return payMapper.toDto(payRepo.save(payment));
    }

    @Transactional
    public PaymentDto updatePayment(Long id, PaymentDto patchDto) {
        Payment payment = payMapper.toEntity(getPaymentById(id));
        payMapper.updateFromDto(patchDto, payment);
        Payment savedPayment = payRepo.save(payment);
        return payMapper.toDto(savedPayment);
    }

    @Transactional
    public PaymentDto deletePayment(Long id) {
       Payment payment =payMapper.toEntity(getPaymentById(id));
       payRepo.delete(payment);
       return payMapper.toDto(payment);
    }

}
