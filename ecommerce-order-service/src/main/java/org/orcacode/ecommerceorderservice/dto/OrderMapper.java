package org.orcacode.ecommerceorderservice.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.orcacode.ecommerceorderservice.entity.Order;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);

    void updateFromDto(OrderDto orderDto,@MappingTarget Order order);
}
