package com.lcwd.user.service.UserService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.entity.Hotel;
import com.lcwd.user.service.UserService.entity.Rating;
import com.lcwd.user.service.UserService.entity.User;
import com.lcwd.user.service.UserService.externalService.HotelService;
import com.lcwd.user.service.UserService.repository.UserRepository;

import jakarta.ws.rs.core.Response;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
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
	    
	 Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/Ratings/User/"+ user.getId(), Rating[].class);
	   
	   List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

	// logger.info("Ratings retrieved from the service: {}", ratingOfUser);
	 //user.setRatings(ratingOfUser);
	
	 
	 List<Rating> ratingList = ratings.stream().map(rating ->{
		 
		//ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/Hotels/" + rating.getHotelId(), Hotel.class);
		Hotel hotel =hotelService.getHotel(rating.getHotelId());
		
		rating.setHotel(hotel);
		 
		 return rating;
	 }).collect(Collectors.toList());
	 user.setRatings(ratingList);
		return user;
	}


}
