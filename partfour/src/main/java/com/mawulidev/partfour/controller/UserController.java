package com.mawulidev.partfour.controller;

import com.mawulidev.partfour.dto.ResponseHandler;
import com.mawulidev.partfour.dto.UserDTO;
import com.mawulidev.partfour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        return ResponseHandler.successResponse(HttpStatus.CREATED, userService.createUser(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return ResponseHandler.successResponse(HttpStatus.OK, userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseHandler.successResponse(HttpStatus.OK, userService.updateUser(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        return ResponseHandler.successResponse(HttpStatus.OK, deleted ? "User deleted successfully" : "User not found");
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseHandler.successResponse(HttpStatus.OK, userService.getAllUsers());
    }

}
