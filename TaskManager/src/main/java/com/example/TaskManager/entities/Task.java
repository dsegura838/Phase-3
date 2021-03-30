package com.example.TaskManager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

import java.util.Date;

@Entity

public class Task {

	
//	@Override
//	public String toString() {
//		return "Task [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", severity="
//				+ severity + ", description=" + description + "]";
//	}

	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer id;
	   private String name;
	   @DateTimeFormat(pattern="dd/MM/yyyy")
	   @Temporal(TemporalType.DATE)
	   private Date startDate;
	   @Temporal(TemporalType.DATE)
	   @DateTimeFormat(pattern="dd/MM/yyyy")
	   private Date endDate;
	   private String severity;
	   private String description;
	   //private String email;
	  
	   //private int userID;
	   
	   ///////////////////////////////////////////////////Might need to fix
	   @ManyToOne(fetch =FetchType.LAZY)
	   @JoinColumn(name="user", nullable=true)
	   //referencedColumnName = "id"
	   private User user;
	   
	  //int userID 
	public Task(String name, Date startDate, Date endDate, String severity, String description,
			User user) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.severity = severity;
		this.description = description;
		this.user = user;
	}
	
	public Task() {
		
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
