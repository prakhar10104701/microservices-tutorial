package com.microservices.userservice.external.services;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.microservices.userservice.entities.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	@PostMapping("/rating")
	public Rating createRating(Rating values);
	
	@PutMapping("/rating/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId, Rating rating);
}
