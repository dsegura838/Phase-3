package com.example.TaskManager.entities;


//import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Override
    public String toString() {
    	return (id.toString() + " " + name + " " + email + " " + password);
    }

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;
    
    private String password;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Task> tasks;
    // = new ArrayList<>()
    
    //May need to change////////////////////////
    public List<Task> getTasks() {
		return tasks;
	}
    //May need to change////////////////////////
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	public void removeTask(Task task) {
		this.tasks.remove(task);
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}