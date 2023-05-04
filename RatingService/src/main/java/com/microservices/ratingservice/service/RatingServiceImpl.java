package com.microservices.ratingservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.ratingservice.entity.Rating;
import com.microservices.ratingservice.exception.ResourceNotFoundException;
import com.microservices.ratingservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	RatingRepository ratingrepository;
	
	@Override
	public Rating createRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingrepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingrepository.findAll();
	}

	@Override
	public List<Rating> getRatingByuserId(String userId) {
		return ratingrepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingrepository.findByHotelId(hotelId);
	}

}
