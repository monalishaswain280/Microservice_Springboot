package com.icwd.rating.service.RatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icwd.rating.service.RatingService.Entity.Rating;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Integer>{
	
	List<Rating> getRatingByUserId(int userId);
	
	List<Rating> getRatingByHotelId(int hotelId);

}
