package com.example.UserFeedback.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Feedback {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String comments;
	private int rating;
	private String user;

	public void setId(Integer id) {
		this.id = id;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public String getComments() {
		return comments;
	}
	public int getRating() {
		return rating;
	}
	public String getUser() {
		return user;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(String user, int rating, String comments) {
		super();
		this.comments = comments;
		this.rating = rating;
		this.user = user;
	}
}