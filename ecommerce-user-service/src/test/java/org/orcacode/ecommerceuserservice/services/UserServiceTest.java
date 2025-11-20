package org.orcacode.ecommerceuserservice.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.orcacode.ecommerceuserservice.entity.User;
import org.orcacode.ecommerceuserservice.repository.UserRepo;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/6/2025
 */
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userSrv;

    @Test
    void getUserById() {
        User user = new User();
        LocalDate date = LocalDate.now();
        UUID uuid = UUID.randomUUID();

//        user.setId(uuid);
        user.setUserName("Alireza");
        user.setEmail("Alireza@gmail.com");
        user.setCreationDate(date);

        when(userRepo.findById(uuid)).thenReturn(Optional.of(user));

        User returnedUser = userSrv.getUserById(uuid);
        assertEquals(user, returnedUser);

    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void updateUser() {
    }
}