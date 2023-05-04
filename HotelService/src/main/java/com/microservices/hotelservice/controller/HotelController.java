package com.microservices.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.hotelservice.entity.Hotel;
import com.microservices.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		List<Hotel> hotels = hotelService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> get(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	}
	
	
}
