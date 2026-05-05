package ir.orcacode.ecommerceorderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import ir.orcacode.ecommerceorderservice.dto.OrderDto;
import ir.orcacode.ecommerceorderservice.entity.Order;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDto toDto(Order entity);
    Order toEntity(OrderDto dto);
    void updateFromDto(OrderDto dto,@MappingTarget Order entity);
}
