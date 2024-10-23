package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserRegistrationService;

@Controller
public class ViewController {
	
	private final UserRegistrationService userRegistrationService;
	
	@Autowired
	public ViewController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	
	@GetMapping("/api/user/create")
    public String showUserRegistrationForm() {
        return "user"; // Return the JSP view name for the user registration form
    }

}
