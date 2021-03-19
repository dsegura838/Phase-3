package com.example.UserFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.repositories.FeedbackRepository;

@SpringBootApplication
@EnableJpaRepositories
public class UserFeedbackApplication {

	@Autowired
	//private static 
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(UserFeedbackApplication.class, args);
		
		FeedbackRepository feedbackRepository = ctx.getBean(FeedbackRepository.class);
		
		feedbackRepository.findAll();
		
	}

}
