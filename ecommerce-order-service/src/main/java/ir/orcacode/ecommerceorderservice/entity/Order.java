package ir.orcacode.ecommerceorderservice.entity;

import ir.orcacode.ecommerceorderservice.infrastructure.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@Entity
@SQLDelete(sql="UPDATE tasks SET isDeleted=true, updatedAt= CURRENT_TIMESTAMP WHERE id=?")
@Where(clause="isDeleted=false" )
@Table(name = "ec_order",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order extends BaseEntity {

    @Column(unique = false , nullable = false)
    private UUID user_id;
    @Column(unique = false , nullable = false)
    private Float total_price;
    @Column(unique = false , nullable = false)
    private String order_status;
    @Column(unique = false , nullable = false)
    private LocalDate order_date;
}
