package com.example.UserManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.UserManager.entities.User;
import com.example.UserManager.repositories.UserRepository;

@Transactional
@Service("UserService")
public class UserServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	
	//@Override
	public User update(User user) {
		return userRepository.save(user);
	}

}
