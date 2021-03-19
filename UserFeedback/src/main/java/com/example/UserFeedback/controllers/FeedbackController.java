package com.example.UserFeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;
import com.example.UserFeedback.controllers.FeedbackController;

@RestController

public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	 
	@GetMapping(value = "/feedback", produces = "application/json")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.GetAllFeedback();
    }
	
	//curl -X POST localhost:8090/feedback -H "Content-type:application/json" -d "{\"comments\":\"Awesome\",\"rating\":10,\"user\":\"tim\"}"
	@PostMapping(value = "/feedback")
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) {
		
		feedbackService.addFeedback(newFeedback);
		// Add the Feedback.
		return newFeedback;
	}
	

}
