package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.UserRegistration;
import com.example.demo.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;

    @Autowired
    public UserRegistrationService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    // Mapping UserRequest to UserRegistration entity
    public UserRegistration mapToUser(UserRequest userRequest) {
        return UserRegistration.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword()) // Remember to hash passwords
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .phoneNumber(userRequest.getPhoneNumber())
                .address(userRequest.getAddress())
                .build();
    }

    // Mapping UserRegistration entity to UserResponse DTO
    public UserResponse mapToUserResponse(UserRegistration user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .build();
    }

    // Create User
    public UserResponse createUser(UserRequest userRequest) {
        UserRegistration user = mapToUser(userRequest);
        user = userRegistrationRepository.save(user);
        return mapToUserResponse(user);
    }

    // Get User by Id
    public UserResponse getUserById(Long id) {
        UserRegistration user = (UserRegistration) userRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToUserResponse(user);
    }

    // Update User by Id
    public UserResponse updateUserById(Long id, UserRequest userRequest) {
        UserRegistration existingUser = (UserRegistration) userRegistrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(userRequest.getUsername());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPassword(userRequest.getPassword()); // Hash the password
        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());
        existingUser.setPhoneNumber(userRequest.getPhoneNumber());
        existingUser.setAddress(userRequest.getAddress());

        UserRegistration updatedUser = userRegistrationRepository.save(existingUser);
        return mapToUserResponse(updatedUser);
    }

    // Delete User by Id
    public boolean deleteUserById(Long id) {
        try {
            userRegistrationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all users
    public List<UserResponse> getAllUsers() {
        List<UserRegistration> users = userRegistrationRepository.findAll();
        return users.stream()
                    .map(this::mapToUserResponse)
                    .collect(Collectors.toList());
    }

}
