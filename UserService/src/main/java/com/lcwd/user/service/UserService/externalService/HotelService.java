package com.lcwd.user.service.UserService.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.service.UserService.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
 public interface HotelService {
	
	@GetMapping("Hotels/{hotelId}")
	Hotel getHotel(@PathVariable  int hotelId);

}
