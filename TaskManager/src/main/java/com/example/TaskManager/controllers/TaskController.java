package com.example.TaskManager.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;
import com.example.TaskManager.entities.User;

@Controller
//<User>
public class TaskController {
	
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	//start page
	@GetMapping(value="/")
    public String showIndexPage() {   
		 return "index";
    }
	
	//add new tasks
	@GetMapping(value="/add/{id}")
    public String showTaskPage(ModelMap model, @PathVariable("id") int id) {   
		
		model.addAttribute("userID", id);
		
		return "addTask";
	}
	
	@PostMapping(value="/add")
	public String addTask(ModelMap model, @RequestParam String name, @RequestParam Date sdate,
			@RequestParam Date edate, @RequestParam String description, @RequestParam String severity, @RequestParam int userID) {
		User user = userService.GetUserById(userID);
		
		Task task = new Task(name, sdate, edate, severity, description, user);
		taskService.addTask(task);
		return "success";
	}
	
	@RequestMapping(value="/display/{id}", method = RequestMethod.GET)
	//
	//ModelMap model, User user
	public String showTasks(@PathVariable("id") int id,ModelMap model) {
		User user = userService.GetUserById(id);
		Iterable<Task> task = taskService.GetTasksByUser(user);
		
		model.addAttribute("tasks", task);
		
		return "GetTasks";
	}
//	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//	public String update(Map<String, Object> map, @PathVariable("id") int id) {
//		//User user = userService.GetUserById(id);
//		Task task = taskService.getTaskByID(id);
//		map.put("userID", id);
//		map.put("task", task);
////		model.addAttribute("userID", id);
////		model.addAttribute("task", task);
//		
//		
//		return "edit";
//	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("id") int id) {
		//User user = userService.GetUserById(id);
		Task task = taskService.getTaskByID(id);
		
		model.addAttribute("userID", id);
		model.addAttribute("task", task);
		
		
		return "edit";
	}
	@PostMapping(value="/update")
	public String updateTask(ModelMap model, @RequestParam String name, @RequestParam Date sdate,
			@RequestParam Date edate, @RequestParam String description, @RequestParam String severity, @RequestParam int userID, @RequestParam int taskId) {
		User user = userService.GetUserById(userID);
/////////////////////////
		Task task = taskService.getTaskByID(taskId);
		task.setName(name);
		task.setStartDate(edate);
		task.setEndDate(edate);
		task.setDescription(description);
		task.setSeverity(severity);
		task.setUser(user);
		
		System.out.println(taskId);
/////////////////////////
		//Task task = new Task(name, sdate, edate, description, severity, user);
		taskService.UpdateTask(task);
		return "success";
	}
	

	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") int id, Map<String, Object> map) {
		
		System.out.println(id);
		taskService.DeleteTask(id);
		return "success";
	}
	
	

}
