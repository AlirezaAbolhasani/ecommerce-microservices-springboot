package org.orcacode.ecommerceorderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.orcacode.ecommerceorderservice.dto.OrderItemsDto;
import org.orcacode.ecommerceorderservice.entity.OrderItems;

import java.util.List;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderItemsMapper {
    OrderItemsMapper INSTANCE = Mappers.getMapper(OrderItemsMapper.class);
    OrderItemsDto toDto(OrderItems orderItems);
    OrderItems toEntity(OrderItems orderItems);
    List<OrderItemsDto> toDto(List<OrderItems> orderItems);
    List<OrderItems> toEntity(List<OrderItemsDto> orderItemsDto);
    OrderItemsDto updateFromDto(OrderItemsDto dto , @MappingTarget OrderItems entity);
}
