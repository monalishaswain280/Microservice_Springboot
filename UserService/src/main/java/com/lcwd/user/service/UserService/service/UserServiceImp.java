package com.lcwd.user.service.UserService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.entity.Rating;
import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

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
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    
	    //http://localhost:8082/Ratings/User/2
	    
	 ArrayList<Rating> ratingOfUser = restTemplate.getForObject("http://localhost:8082/Ratings/User/"+ user.getId(), ArrayList.class);
	    
	 logger.info("Ratings retrieved from the service: {}", ratingOfUser);
	 user.setRatings(ratingOfUser);
	 System.out.printf("This is userRating: %s%n", ratingOfUser);
	 
	 List<Rating> ratingList = ratingOfUser.stream().map(rating ->{
		 
		 restTemplate.getForEntity(null, null);
		 
		 return rating;
	 }).collect(Collectors.toList());
	 user.setRatings(ratingList);
		return user;
	}


}
