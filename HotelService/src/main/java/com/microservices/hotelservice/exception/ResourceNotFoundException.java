package com.microservices.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468639343999356198L;
	
	public ResourceNotFoundException(){
		super("Resource Not Found !!");
	}
	
	public ResourceNotFoundException(String message){
		super(message);
	}

}
