package com.icwd.rating.service.RatingService.controller;

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

import com.icwd.rating.service.RatingService.Entity.Rating;
import com.icwd.rating.service.RatingService.service.RatingService;

@RestController
@RequestMapping("/Ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		
		Rating rate = ratingService.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rate);
		
	}
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> rate = ratingService.getAllRatings();
		return ResponseEntity.ok(rate);
		
	}
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable int ratingId){
		Rating rate = ratingService.getRatingById(ratingId);
		return ResponseEntity.ok(rate);
		
	}
	
	@GetMapping("/User/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable int userId){
		List<Rating> rate = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(rate);
		
	}

	
	@GetMapping("/Hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable int hotelId){
		List<Rating> rate = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(rate);
		
	}


}
