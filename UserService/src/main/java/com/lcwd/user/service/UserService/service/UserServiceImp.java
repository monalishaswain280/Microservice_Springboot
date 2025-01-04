package com.lcwd.user.service.UserService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
	    // Attempt to find the user by ID
	    return userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}


}
