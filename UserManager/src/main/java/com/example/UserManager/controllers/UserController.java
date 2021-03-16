package com.example.UserManager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting User");
		Iterable<User> users = userService.GetAllUsers();
		
		
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "users";
    }
	
	@GetMapping("/search")
	public String FindByID(ModelMap model, @RequestParam int id) {
		
		logger.info("Getting user by ID");
		
		User users = userService.GetUserById(id);
		
		//create arraylist to store our user values
		List<User> u = new ArrayList<>();
		
		//add users to arraylist
		u.add(users);
		
		//map arraylist to users label which 
		//will be used to identify data in users.jsp
		logger.info("Passing users to view");
		model.addAttribute("users", u);
		
		return "users";		
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editRecord(@PathVariable("id") int id, Map<String, Object> map) 
	{	
		logger.info("Find user by ID");
		User user = userService.GetUserById(id);
		map.put("user", user);
		
		return "edit";	
	}
	
	@RequestMapping(value = "/edit/{id}/update", method = RequestMethod.POST)
	public String update(User user, Map<String, Object> map) {
		userService.UpdateUser(user);
		return "success";
	}
//	@RequestMapping(method = RequestMethod.GET)
//	public String index(ModelMap modelMap) {
//		modelMap.put("user", new User());
//		return "update.jsp";
//	}
//
//	@RequestMapping(value = "save", method = RequestMethod.POST)
//	public String save(@ModelAttribute("user") User user) {
//		userService.UpdateUser(user);
//		return "success";
//	}
	

}
