package ir.orcacode.ecommerceorderservice.entity;

import ir.orcacode.ecommerceorderservice.infrastructure.meta.GeneratedBy;
import ir.orcacode.ecommerceorderservice.infrastructure.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import java.math.BigDecimal;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/12/2025
 */
@Entity
@Table(name = "ec_order_items",schema = "public")
@SQLDelete(sql="UPDATE ${table} SET isDeleted=true, updatedAt= CURRENT_TIMESTAMP WHERE id=?")
@Where(clause="isDeleted=false" )
@GeneratedBy(value = "ServiceGenerator",version = "1.0",module = "Order",description = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItems extends BaseEntity{
    @Column(unique = false,nullable = false)
    private Long order_id; // REFERENCES orders(id),
    @Column(unique = false , nullable = false)
    private Long product_id;
    @Column(unique = false , nullable = false)
    private String product_name; //SnapShot of name purchaseTime
    @Column(nullable = false)
    private BigDecimal product_price; //Snapshot from price in purchaseTime
    @Column(nullable = false)
    private Integer quantity;
}
