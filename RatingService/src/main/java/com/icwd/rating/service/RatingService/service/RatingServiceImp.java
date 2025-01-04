package com.icwd.rating.service.RatingService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icwd.rating.service.RatingService.Entity.Rating;
import com.icwd.rating.service.RatingService.repository.RatingRepository;

@Service
public class RatingServiceImp  implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating saveRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRatingById(int  ratingId) {
		// TODO Auto-generated method stub
		return ratingRepository.findById(ratingId).orElseThrow(() -> new RuntimeException("Rating not found in this id "+ ratingId) );
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		// TODO Auto-generated method stub
		return ratingRepository.getRatingByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.getRatingByHotelId(hotelId);
	}

}
