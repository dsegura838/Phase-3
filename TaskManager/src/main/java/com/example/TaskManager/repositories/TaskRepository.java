package com.example.TaskManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    public Task findByName(String name);
    
    public Task findById(int id);
    
    //public Iterable<Task> findAllByUser_ID(int id);
    public Iterable<Task> findAllByUser(User user);
}