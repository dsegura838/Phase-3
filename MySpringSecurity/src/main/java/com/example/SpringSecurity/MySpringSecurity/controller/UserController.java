package com.example.SpringSecurity.MySpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String home() {
		//TODO:Will change
		return "/login";
	}
	
	@RequestMapping("/home")
	public String homePage() {
		//TODO:Will change
		return "loginSuccess";
	}
	
}
