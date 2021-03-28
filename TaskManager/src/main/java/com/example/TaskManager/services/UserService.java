package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.exceptions.UserNotFoundException;
import com.example.TaskManager.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> GetAllUsers() {
		
		return userRepository.findAll();
	}
	
//	public boolean checkPwd(String password) {
//		User foundUser = userRepository.;
//		if()
//	}
	
	public User validate(String password, String email) {
		User foundUser = userRepository.findByEmail(email);
		
		if(foundUser != null && foundUser.getPassword().equals(password)) {
			
			return foundUser;
		}else {
			throw new UserNotFoundException();
		}
	}
//	public User GetUserByEmail(String email) {
//		
//		User foundUser = userRepository.findByEmail(email);
//		
//		if(isValid(email)) {
//			throw new UserNotFoundException();
//			
//		}
//		return foundUser;
//	}
	
	public boolean isValid(String email) {
		
		try {
			User foundUser = userRepository.findByEmail(email);
			
			if(!foundUser.equals(null)) {
				
				return false;
			}
			
			return true;
		}
		catch(Exception ex){
			
			return true;
			
		}

	}
	
	public User GetUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }
    
    public User AddUser(User usertoAdd) {
    	
    	return userRepository.save(usertoAdd);
    }
}
