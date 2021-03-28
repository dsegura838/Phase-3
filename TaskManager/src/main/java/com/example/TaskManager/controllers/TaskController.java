package com.example.TaskManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	//start page
	@GetMapping(value="/")
    public String showIndexPage() {   
		 return "index";
    }
	
	//add new tasks
	@GetMapping(value="/add")
    public String showTaskPage() {   

		return "addTask";
	}
	
	
//	@RequestMapping(value = "/error")
//	public String showError() {
//		return "index";
//	}
	

}
