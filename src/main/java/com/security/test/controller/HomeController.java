package com.security.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String getHome() {
		return "Home Page";
	}
	@GetMapping("/login")
	public String getLogin() {
		return "Login Page";
	}
	@GetMapping("/register")
	public String getRegister() {
		return "Register Page";
	}
}
