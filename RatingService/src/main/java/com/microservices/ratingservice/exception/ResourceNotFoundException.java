package com.microservices.ratingservice.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(){
		super("Resourse not found");
	}
	
	public ResourceNotFoundException(String message){
		super(message);
	}

}
