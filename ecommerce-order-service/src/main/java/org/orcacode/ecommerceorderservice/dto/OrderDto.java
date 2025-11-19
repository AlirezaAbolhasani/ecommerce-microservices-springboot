package org.orcacode.ecommerceorderservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class OrderDto {
    private Long id;
    private UUID user_id;
    private Float total_price;
    private String order_status;
    private LocalDate order_date;
}
