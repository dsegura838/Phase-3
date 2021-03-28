package com.example.TaskManager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.UserService;
import com.example.TaskManager.controllers.UserController;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//display register page
	@GetMapping(value="/register")
	public String showRegisterPage() {
		return "register";
	}
	
	//add new users
	@PostMapping(value="/register")
	public String processRegisterPage(User newUser) {
		
		
		userService.AddUser(newUser);
		//will change
		return "RegisterSuccess";
	}
	
	//login form
	@GetMapping(value="/login")
	public String showLogin() {
		
		
		return "login";
	}
	
	//login processing
	@PostMapping(value="/login")
	public String validate( @RequestParam String email, @RequestParam String password) {
		
		userService.validate(password, email);
		
		return "TaskOptions";
	}
	

}
