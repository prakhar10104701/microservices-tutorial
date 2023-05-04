package com.microservices.userservice.service;

import java.util.List;

import com.microservices.userservice.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	User getuser(String userId);
	
	List<User> getAllUser();
}
