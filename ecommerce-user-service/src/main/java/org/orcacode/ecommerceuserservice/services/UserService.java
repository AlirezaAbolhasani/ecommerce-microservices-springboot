package org.orcacode.ecommerceuserservice.services;

import org.orcacode.ecommerceuserservice.entity.User;
import org.orcacode.ecommerceuserservice.excption.BusinessException;
import org.orcacode.ecommerceuserservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.orcacode.ecommerceuserservice.messages.Messages.*;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@Service
@Lazy(value = true)
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public User getUserById(UUID id) {
        return userRepo.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Id not found =" + id));
    }
    @Transactional
    public User getUserByEmail(String email) {
        return Optional.of(userRepo.findByEmail(email)).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Email not found = " + email));
    }
    @Transactional
    public User saveUser(User user) {
        if(user== null){
            throw new BusinessException(HttpStatus.BAD_REQUEST, "User annot be null");
        }else{
            return userRepo.save(user);
        }
    }
    @Transactional
    public User deleteUser(UUID id) {
        if(id == null) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Id cannot be null");
        }
        User user= getUserById(id);
        if(user != null){
            userRepo.deleteById(id);
        }
        return user;
    }
    @Transactional
    public List<User> getAllUsers() {
        return Optional.of(userRepo.findAll()).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "List is Empty."));
    }
    @Transactional
    public void updateUser(User _user) {
        User user = new User();
        user = userRepo.findById(_user.getId()).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "User not found =" + _user.getId()));
        user.setUserName(_user.getUserName());
        user.setEmail(_user.getEmail());
        userRepo.save(user);
    }
}
