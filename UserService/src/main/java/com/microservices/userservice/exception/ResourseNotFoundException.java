package com.microservices.userservice.exception;

public class ResourseNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8143087489186871807L;

	public ResourseNotFoundException() {
		super("Resourse not found on server !!");
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}
}
