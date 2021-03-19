package com.example.UserFeedback.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class TestFormController {
	
	@GetMapping("/")
	public String showTestForm() {
		
		return "index.html";
	}

}
