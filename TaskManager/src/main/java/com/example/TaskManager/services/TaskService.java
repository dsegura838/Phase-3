package com.example.TaskManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.repositories.TaskRepository;

@Service
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserService userService;
	
	public Iterable<Task> GetAllTasks() {
	
		return taskRepository.findAll();
	}

	public Iterable<Task> GetTasksByUser(User user) {
		//TODO: what do we do if the user doesn't have any tasks or doesn't exist?
		
		
		return(taskRepository.findAllByUser(user));
	}
	
//	public Iterable<Task> GetTasksByUser_ID(int id) {
//	//TODO: what do we do if the user doesn't have any tasks or doesn't exist?
//	
//	
//	return (taskRepository.findAllByUser_ID(id));
//}
	//add new task
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}

	public void UpdateTask(Task task) {
		// TODO Auto-generated method stub
		taskRepository.save(task);
	}
	public void DeleteTask(int id) {
		taskRepository.deleteById(id);
		//taskRepository.delete(task);
	}
}
