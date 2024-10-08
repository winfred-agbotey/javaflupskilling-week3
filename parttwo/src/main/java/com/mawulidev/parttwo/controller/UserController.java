package com.mawulidev.parttwo.controller;

import com.mawulidev.parttwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * UserController is a REST controller that exposes API endpoints for fetching user data.
 * It interacts with the UserService to retrieve user information.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    /**
     * Constructor-based dependency injection for UserService.
     * @param userService the service that provides user-related business logic
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to get a user by their ID.
     * Example: GET /user/1 will return the user with ID 1.
     * @param id the ID of the user
     * @return the name of the user
     */
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

}
