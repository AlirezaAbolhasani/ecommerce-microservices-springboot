package org.orcacode.ecommerceorderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import org.orcacode.ecommerceorderservice.entity.OrderItems;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@Mapper(componentModel = "spring"
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderItemsMapper {
    OrderItemsMapper INSTANCE = Mappers.getMapper(OrderItemsMapper.class);
    OrderItemsDto toDto(OrderItems orderItems);
    OrderItems toEntity(OrderItemsDto orderItems);
    OrderItemsDto updateFromDto(OrderItemsDto dto , @MappingTarget OrderItems entity);
}
