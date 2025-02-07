package com.lcwd.user.service.UserService.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;

import java.util.*;

@Entity
@Table(name = "micro_users")
@Builder
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  String userName;
	private String userEmail;
	private String userAbout;
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	public User() {
		
	}
	
	
	public User(int id, String userName, String userEmail, String userAbout, List<Rating> ratings) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAbout = userAbout;
		this.ratings = ratings;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAbout() {
		return userAbout;
	}
	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	

}
