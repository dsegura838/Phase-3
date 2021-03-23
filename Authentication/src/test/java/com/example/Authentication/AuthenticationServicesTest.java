package com.example.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;

@SpringBootTest
@Transactional
public class AuthenticationServicesTest {
	
	
	@Autowired
	UserService userService;

	Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);
	

  @Test
  public void whenPasswordMatches_thenReturnSuccess() {
  
  	
  	//when
  	String result = userService.validate("world", "hello");
  	
  	//then
  	assertEquals("success", result);
  }
  @Test
  public void whenIncorrectPassword_thenReturnFail() {
	  //when
	  String result = userService.validate("1234", "hello");
	  
	  //then
	  assertEquals("fail", result);
  }



}
