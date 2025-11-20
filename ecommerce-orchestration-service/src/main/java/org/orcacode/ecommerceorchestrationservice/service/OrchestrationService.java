package org.orcacode.ecommerceorchestrationservice.service;

import org.orcacode.ecommerceorchestrationservice.repository.OrchestrationRepository;
import org.orcacode.ecommerceuserservice.entity.User;
import org.orcacode.ecommerceuserservice.repository.UserRepo;
import org.orcacode.ecommerceuserservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/20/2025
 */
@Service
public class OrchestrationService {
    OrchestrationRepository orchestrationRepository;
    UserService userService;
    UserRepo userRepo;
    @Autowired
    public OrchestrationService(OrchestrationRepository orchestrationRepository) {
        this.orchestrationRepository = orchestrationRepository;
        this.userService = new UserService(userRepo);
    }
    @Transactional
    public String getList(){
        User user = new User();
        user.setUserName("admin");
        user.setEmail("admin@admin.com");
        user =userService.saveUser(user);
        return user.toString();
    }

}
