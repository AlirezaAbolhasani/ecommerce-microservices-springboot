package org.orcacode.ecommerceuserservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.orcacode.ecommerceuserservice.entity.User;
import org.orcacode.ecommerceuserservice.excption.BusinessException;
import org.orcacode.ecommerceuserservice.messages.Messages;
import org.orcacode.ecommerceuserservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/5/2025
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userSrv;

    public UserController(UserService userSrv) {
        this.userSrv = userSrv;
    }

    /**
     * Find a user by userID. This number is unique and personally.
     *
     * @param id user id
     * @return user information
     */
    @GetMapping("users/{id}")
    @Operation(summary = "Find a user by userID. This number is unique and personally.",
            description = "Id must exist")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = Messages.USER_SUCCESSFULLY_FOUND
                    , content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = User.class))
            }
            ),
            @ApiResponse(
                    responseCode = "404", description = Messages.USER_NOT_FOUND
                    , content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BusinessException.class))
            }
            )
    })
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(userSrv.getUserById(id));
    }

    /**
     * Insert a new user to DB.
     *
     * @param userName Provides the name
     * @param email    Provides the email
     * @return Provide User inserted all data
     */
    @PostMapping("users/")
    @Operation(summary = "Insert a new user to DB",
            description = "UserName and email address are necessary")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = Messages.INSERT_USER_SUCCESSFULLY,
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class))
                    }
            )
    })
    public ResponseEntity<User> addUser(String userName, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setCreationDate(LocalDate.now());
        User newUser = userSrv.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    /**
     * Update values like email and  e-commerce's user table.
     *
     * @param user in user just will update name and email address
     * @return user that information will chang or not
     */
    @PatchMapping("users/{id}")
    @Operation(summary = "Update values like email and  e-commerce's user table",
            description = "Just you can update email and username")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = Messages.UPDATED_USER_SUCCESSFULLY,
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = Messages.USER_NO_CONTENT,
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema)}
            )
    })
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userSrv.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Use user Id to delete user from e-commerce's user table.
     *
     * @param id that need to delete its information
     * @return user that information will delete or not
     */
    @DeleteMapping("users/{id}")
    @Operation(summary = "Use user Id to delete user from e-commerce's user table",
            description = "Id is necessary entry.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = Messages.DELETED_USER_SUCCESSFULLY,
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = Messages.USER_NOT_FOUND,
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema)}
            )
    })
    public ResponseEntity<User> deleteUser(@PathVariable UUID id) {
        return new ResponseEntity<>( userSrv.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
