package com.example.Authentication.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;



@Controller
public class LoginController {
	
	@Autowired
	UserService service = new UserService();
	Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String showGreeting(ModelMap map) {
        return "greeting";
    }


    @GetMapping("/login")
    public String showLogin(ModelMap map) {
    	
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String name, @RequestParam String password){

        //TODO:
    	
    	
    	logger.info(name);
    	logger.info(password);
    	String result = service.validate(password, name);
    	

        return result;



    }
}
