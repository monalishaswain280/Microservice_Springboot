package com.lcwd.user.service.UserService.entity;

public class Hotel {

	private int id;
	private String hotelName;
	private String location;
	private String about;
	
	public Hotel() {
		
	}

	public Hotel(int id, String hotelName, String location, String about) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.location = location;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
