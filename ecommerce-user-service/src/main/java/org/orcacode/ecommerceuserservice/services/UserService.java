package org.orcacode.ecommerceuserservice.services;

import org.orcacode.ecommerceuserservice.entity.UserEntity;
import org.orcacode.ecommerceuserservice.excption.BusinessException;
import org.orcacode.ecommerceuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@Service
@Lazy(value = true)
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public UserEntity getUserById(UUID id) {
        return userRepo.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Id not found =" + id));
    }

    @Transactional
    public UserEntity getUserByEmail(String email) {
        return Optional.of(userRepo.findByEmail(email)).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Email not found = " + email));
    }

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        if (user == null) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "User annot be null");
        } else {
            return userRepo.save(user);
        }
    }

    @Transactional
    public UserEntity deleteUser(UUID id) {
        if (id == null) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Id cannot be null");
        }
        UserEntity user = getUserById(id);
        if (user != null) {
            userRepo.deleteById(id);
        }
        return user;
    }

    @Transactional
    public List<UserEntity> getAllUsers() {
        return Optional.of(userRepo.findAll()).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "List is Empty."));
    }

    @Transactional
    public void updateUser(UserEntity _user) {
        UserEntity user = new UserEntity();
        user = userRepo.findById(_user.getId()).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "User not found =" + _user.getId()));
        user.setUserName(_user.getUserName());
        user.setEmail(_user.getEmail());
        userRepo.save(user);
    }
}
