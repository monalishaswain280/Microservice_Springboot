package com.lcwd.hotel.HotelService.controller;

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

import com.lcwd.hotel.HotelService.entity.Hotel;
import com.lcwd.hotel.HotelService.service.HotelService;

@RestController
@RequestMapping("/Hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.addHotel(hotel));
		
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> hotel = hotelService.getAllHotel();
		return ResponseEntity.ok(hotel);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
		Hotel hotel = hotelService.getHotelById(id);
		return ResponseEntity.ok(hotel);
		
	}

}
