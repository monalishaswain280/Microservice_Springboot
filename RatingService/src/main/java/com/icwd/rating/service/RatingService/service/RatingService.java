package com.icwd.rating.service.RatingService.service;

import java.util.List;

import com.icwd.rating.service.RatingService.Entity.Rating;

public interface RatingService {
	
	 Rating saveRating(Rating rating);
	
	 List<Rating> getAllRatings();
	
	 Rating getRatingById(int  ratingId);

	 List<Rating> getRatingByUserId( int userId);
	 
	 List<Rating> getRatingByHotelId(int hotelId);
}
