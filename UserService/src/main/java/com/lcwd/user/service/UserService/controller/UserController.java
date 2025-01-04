package com.lcwd.user.service.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	public ResponseEntity<User> getUserById( @PathVariable int  userId){
		User user1 = userService.getUserById(userId);
		return ResponseEntity.ok(user1);
		
	}

}
