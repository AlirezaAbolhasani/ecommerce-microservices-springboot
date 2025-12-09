package org.orcacode.ecommerceuserservice.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.orcacode.ecommerceuserservice.entity.UserEntity;
import org.orcacode.ecommerceuserservice.repository.UserRepository;
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
    private UserRepository userRepo;

    @InjectMocks
    private UserService userSrv;

    @Test
    void getUserById() {
        UserEntity user = new UserEntity();
        LocalDate date = LocalDate.now();
        UUID uuid = UUID.randomUUID();

//        user.setId(uuid);
        user.setUserName("Alireza");
        user.setEmail("Alireza@gmail.com");
        user.setCreationDate(date);

        when(userRepo.findById(uuid)).thenReturn(Optional.of(user));

        UserEntity returnedUser = userSrv.getUserById(uuid);
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