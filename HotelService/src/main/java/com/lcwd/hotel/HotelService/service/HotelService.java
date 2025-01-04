package com.lcwd.hotel.HotelService.service;

import java.util.List;

import com.lcwd.hotel.HotelService.entity.Hotel;

public interface HotelService {
	
	 Hotel addHotel(Hotel hotel);
	 
	 List<Hotel> getAllHotel();
	 
	 Hotel getHotelById(int id);

}
