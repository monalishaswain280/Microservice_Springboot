package com.lcwd.hotel.HotelService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.repository.HotelRepository;

@Service
public class HotelServiceImp  implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found with thi id" + id));
	}

}
