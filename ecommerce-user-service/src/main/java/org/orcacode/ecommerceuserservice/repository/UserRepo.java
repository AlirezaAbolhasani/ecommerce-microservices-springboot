package org.orcacode.ecommerceuserservice.repository;

import org.orcacode.ecommerceuserservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true, value = "select u.* from public.ec_user u where u.email = :email")
    public Optional<User> findByEmail(@Param("email") String email);
}
