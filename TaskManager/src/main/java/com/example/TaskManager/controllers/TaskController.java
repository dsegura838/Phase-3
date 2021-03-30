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
    public String showTaskPage() {   
		
		return "addTask";
	}
	
	@PostMapping(value="/add")
	public String addTask(ModelMap model, @RequestParam String name, @RequestParam Date sdate,
			@RequestParam Date edate, @RequestParam String description, @RequestParam String severity, @PathVariable("id") int id) {
			
		
//			int id = user.getId();
//					
//			System.out.println(user);
			System.out.println(id);
//			
//			model.addAttribute("id", id);
		
		Task task = new Task(name, sdate, edate, description, severity, id);
		taskService.addTask(task);
		return "TaskOptions";
	}
	
	@RequestMapping(value="/display/{id}", method = RequestMethod.GET)
	//
	//ModelMap model, User user
	public String showTasks(@PathVariable("id") int id,ModelMap model) {
		User user = userService.GetUserById(id);
		Iterable<Task> task = taskService.GetTasksByUser(user);
		
		//create arraylist to store our user values
		//List<Task> t = new ArrayList<>();
				
		//add users to arraylist
		//t.add(task);
		//logger.info("Passing users to view");
		model.addAttribute("tasks", task);
		
		//System.out.println(task.toString());
				
		//Iterable<Task> tasks = taskService.GetTasksByUser(user);
		
		//int id = user.getId();
		
		//System.out.println(id);
		//model.addAttribute("tasks", tasks);
		
		return "GetTasks";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editRecord(@PathVariable("id") int id, Map<String, Object> map) 
	{	
		logger.info("Find task by user");
		
		User user = userService.GetUserById(id);
		
		Iterable<Task> task =taskService.GetTasksByUser(user);
//		Task task = taskService.UpdateTask(task);;
		map.put("task", task);
		
		return "/edit";	
	}
	
	@RequestMapping(value = "/update/{id}/edit", method = RequestMethod.POST)
	public String update(Task task, Map<String, Object> map) {
		taskService.UpdateTask(task);
		return "TaskOptions";
	}
	
	
//	@RequestMapping(value = "/error")
//	public String showError() {
//		return "index";
//	}
	

}
