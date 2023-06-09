package com.microservices.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(10).userId(null).hotel(null).feedback("this is created using feign client.").build();
		Rating savedRating = ratingService.createRating(rating);
		System.out.println("new rating created : "+ savedRating);
	}

}
