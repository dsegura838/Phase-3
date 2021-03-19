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
	
	@PostMapping("/feedback")
	//public Feedback addNewFeedback(@RequestBody Feedback newFeedback)
	public Feedback addNewFeedback(@RequestParam("user")String user, 
			@RequestParam("comment")String comment, @RequestParam("rating")int rating) {
		// TODO: Do something useful here.
		logger.info(user);
		
		Feedback f1 = new Feedback(user, rating, comment);
		
		feedbackService.addFeedback(f1);
		// Add the Feedback.
		return f1;  // Change this.
	}
	

}
