package com.microservices.userservice.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.userservice.entities.Hotel;
import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exception.ResourseNotFoundException;
import com.microservices.userservice.external.services.HotelService;
import com.microservices.userservice.repositories.UserRepository;
import com.microservices.userservice.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository; 
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelservice;
	
	
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public User getuser(String userId) {
		User user =  userRepository.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User with given Id is not found on server "+userId));
		Rating [] ratings = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(), Rating [].class);
		List<Rating> ratingsOfUser = Arrays.asList(ratings);
		List<Rating> ratingList = ratingsOfUser.stream().map(rating ->{
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rating.getHotelId(), Hotel.class);
			//Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelservice.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUsers = new ArrayList<>();
		List<User> getAllUsers = userRepository.findAll();
		for(User user : getAllUsers) {
			user.setRatings(restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(), ArrayList.class));
			allUsers.add(user);
		}
		return allUsers;
	}

}
