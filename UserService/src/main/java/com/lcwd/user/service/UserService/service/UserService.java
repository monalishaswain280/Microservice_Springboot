package com.lcwd.user.service.UserService.service;

import java.util.List;

import com.lcwd.user.service.UserService.entity.User;

public interface UserService {
	 
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUserById(int id);

}
