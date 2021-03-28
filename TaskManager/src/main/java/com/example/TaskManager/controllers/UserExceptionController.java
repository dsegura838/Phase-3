package com.example.TaskManager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.TaskManager.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(value = UserNotFoundException.class)
    public String exception(UserNotFoundException exception) {
       return "UserNotFound";
       //new ResponseEntity<>("error", HttpStatus.NOT_FOUND)
    }


}
