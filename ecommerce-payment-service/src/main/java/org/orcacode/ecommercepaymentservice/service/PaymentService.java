package org.orcacode.ecommercepaymentservice.service;

import org.modelmapper.ModelMapper;
import org.orcacode.ecommercepaymentservice.dto.PaymentDto;
import org.orcacode.ecommercepaymentservice.dto.PaymentMapper;
import org.orcacode.ecommercepaymentservice.entity.PaymentEntity;
import org.orcacode.ecommercepaymentservice.exception.BusinessesException;
import org.orcacode.ecommercepaymentservice.messages.Messages;
import org.orcacode.ecommercepaymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<PaymentDto> getPayment(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return payRepo.findAll(pageable).map(payMapper::toDto);
    }

    @Transactional
    public PaymentDto savePayment(PaymentDto paymentDto) {
        //  First way
        //  Payment payment = modelMapper.map(paymentDto, Payment.class);
        //  Second way
        PaymentEntity payment = payMapper.toEntity(paymentDto);
        return payMapper.toDto(payRepo.save(payment));
    }

    @Transactional
    public PaymentDto updatePayment(PaymentDto patchDto) {
        PaymentEntity payment = payRepo.findById(patchDto.getId()).orElseThrow(() -> new BusinessesException(HttpStatus.NOT_FOUND, Messages.PAYMENT_NOT_FOUND));
        payMapper.updateFromDto(patchDto, payment);
        PaymentEntity savedPayment = payRepo.save(payment);
        return payMapper.toDto(savedPayment);
    }

    @Transactional
    public PaymentDto deletePayment(Long id) {
        PaymentEntity payment = payRepo.findById(id).orElseThrow(() -> new BusinessesException(HttpStatus.NOT_FOUND, Messages.PAYMENT_NOT_FOUND));
        payRepo.delete(payment);
        return payMapper.toDto(payment);
    }

}
