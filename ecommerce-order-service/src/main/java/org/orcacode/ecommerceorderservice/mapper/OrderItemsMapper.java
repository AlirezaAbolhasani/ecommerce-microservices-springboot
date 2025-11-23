package org.orcacode.ecommerceorderservice.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import org.orcacode.ecommerceorderservice.entity.OrderItems;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 * nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
       ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public

interface OrderItemsMapper {
    OrderItemsMapper INSTANCE = Mappers.getMapper(OrderItemsMapper.class);
    OrderItemsDto toDto(OrderItems orderItems);
    OrderItems toEntity(OrderItemsDto orderItems);
//    OrderItemsDto updateFromDto(OrderItemsDto dto , @MappingTarget OrderItems entity);
}
