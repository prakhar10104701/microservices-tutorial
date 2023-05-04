package com.microservices.hotelservice.service;

import java.util.List;

import com.microservices.hotelservice.entity.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	List<Hotel> getAll();
	Hotel get(String id);
	
}
