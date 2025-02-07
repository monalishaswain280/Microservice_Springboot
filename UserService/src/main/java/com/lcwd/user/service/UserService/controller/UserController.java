package com.lcwd.user.service.UserService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	org.apache.logging.log4j.Logger logger;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user1 = userService.getAllUser();
		return ResponseEntity.ok(user1);
		
	}
	
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name= "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUserById( @PathVariable int  userId){
		User user1 = userService.getUserById(userId);
		return ResponseEntity.ok(user1);
		
	}
	
	
	
	public ResponseEntity<User> ratingHotelFallback(int userId, Exception ex) {
	    org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);  // Initialize logger
	    logger.info("Fallback executed because the service is down: {}", ex.getMessage());

	    User user = new User();
	    user.setUserEmail("dummy@123");
	    user.setUserName("Dummy");
	    user.setUserAbout("This user is created as a dummy because some service is down");

	    return new ResponseEntity<>(user, HttpStatus.OK);
	}


}
