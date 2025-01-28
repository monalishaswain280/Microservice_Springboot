package com.lcwd.hotel.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController

public class StaffsController {
	
	@GetMapping("/Staffs")
	public ResponseEntity<List<String>> getStallss(){
		List<String> list = Arrays.asList("Ram","Shyam","Sita");
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}

}
