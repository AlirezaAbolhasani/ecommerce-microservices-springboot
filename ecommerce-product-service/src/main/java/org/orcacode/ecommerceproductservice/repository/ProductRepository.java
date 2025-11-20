package org.orcacode.ecommerceproductservice.repository;

import org.orcacode.ecommerceproductservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/9/2025
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
