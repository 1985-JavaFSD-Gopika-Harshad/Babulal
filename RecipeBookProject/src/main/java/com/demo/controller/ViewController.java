package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/home2")
	public String home2Jsp() {
		return "home2";
	}
	
	@GetMapping("/login")
	public String loginJsp() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerJsp() {
		return "register";
	}
	
	@GetMapping("/addRecipe")
	public String addRecipeJsp() {
		return "addRecipe";
	}
	
	@GetMapping("/recipeDetails")
	public String recipeDetails() {
		return "recipeDetails";
	}
}
