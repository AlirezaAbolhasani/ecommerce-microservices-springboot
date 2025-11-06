package org.orcacode.ecommerceuserservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.orcacode.ecommerceuserservice.entity.User;
import org.orcacode.ecommerceuserservice.services.UserSrv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

    UserSrv userSrv;

    @GetMapping("e-commerce/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        try {
            User user = userSrv.getUserById(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("e-commerce/user/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            userSrv.saveUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("e-commerce/user/{id}")
    @Operation(summary = "Update values like email and  e-commerce's user table")
    public ResponseEntity<User> updateUser(@RequestBody UUID id, @RequestBody User user) {
        try{
            userSrv.updateUser(id,user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(user,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("e-commerce/user/{id}")
    @Operation(summary = "Use user Id to delete user from e-commerce's user table")
    public ResponseEntity<User> deleteUser(@PathVariable UUID id) {
        try {
            userSrv.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
