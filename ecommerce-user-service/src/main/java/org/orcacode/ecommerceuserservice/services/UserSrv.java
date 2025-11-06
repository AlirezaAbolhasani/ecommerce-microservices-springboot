package org.orcacode.ecommerceuserservice.services;

import org.orcacode.ecommerceuserservice.entity.User;
import org.orcacode.ecommerceuserservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@Service
public class UserSrv {

    UserRepo userRepo;

    @Autowired
    public UserSrv(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserById(UUID id) {
       return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found =" + id));
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found =" + email));
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }
    public void deleteUser(UUID id) {
        userRepo.deleteById(id);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public void updateUser(UUID id, User user) {
        try {
            User storedUser = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found =" + id));
            storedUser.setUserName(user.getUserName());
            storedUser.setEmail(user.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
