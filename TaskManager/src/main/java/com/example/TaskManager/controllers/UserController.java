package com.example.TaskManager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;
import com.example.TaskManager.controllers.UserController;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
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
	public String validate( ModelMap model, @RequestParam String email, @RequestParam String password) {
		
		User user = userService.validate(password, email);
		
		//Iterable<Task> t = taskService.GetTasksByUser(user);
		
		//System.out.println(t.toString());
		//create arraylist to store our user values
		List<User> u = new ArrayList<>();
		
		//add users to arraylist
		u.add(user);
		
		logger.info("Passing user details to view");
		model.addAttribute("users", u);
		
		int id = user.getId();
		
		System.out.println(user);
		System.out.println(id);
		
		//model.addAttribute("id", id);
		
		
		
		return "TaskOptions";
	}

}
