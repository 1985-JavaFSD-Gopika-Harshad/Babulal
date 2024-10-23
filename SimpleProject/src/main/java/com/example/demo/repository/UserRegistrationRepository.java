package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long>{
    boolean existsByEmail(String email); // Example custom method

}
