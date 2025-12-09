package org.orcacode.ecommercepaymentservice.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.orcacode.ecommercepaymentservice.entity.PaymentEntity;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaymentMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    PaymentDto toDto(PaymentEntity payment);
    PaymentEntity toEntity(PaymentDto paymentDto);
    void updateFromDto(PaymentDto dto, @MappingTarget PaymentEntity entity);
}
