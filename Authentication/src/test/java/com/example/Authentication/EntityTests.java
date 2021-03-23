package com.example.Authentication;


import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;
import com.example.Authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class EntityTests {

	@Test
	public void WhenSetPassword_CheckGetPassword() {
		User testUser = new User();
		
		testUser.setPassword("mypassword");
		assertEquals(testUser.getPassword(),"mypassword");
	}
	@Test
	public void WhenSetName_CheckGetName() {
		User testUser = new User();
		
		testUser.setName("John");
		assertEquals(testUser.getName(), "John");
	}
	@Test
	public void WhenSetEmail_CheckGetEmail() {
		User testUser = new User();
		
		testUser.setEmail("Mark@gmail.com");
		assertEquals(testUser.getEmail(), "Mark@gmail.com");
	}
	
}
