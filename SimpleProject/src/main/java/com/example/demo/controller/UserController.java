package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.service.UserRegistrationService;

import java.util.List;

@RestController
@RequestMapping("/api/user") // Base URL for user-related endpoints
public class UserController {

    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    // Create User
    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userRegistrationService.createUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Get User by Id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userRegistrationService.getUserById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // Update User by Id
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userRegistrationService.updateUserById(id, userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    // Delete User by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        boolean isDeleted = userRegistrationService.deleteUserById(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userRegistrationService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
