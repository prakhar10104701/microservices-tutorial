package com.microservices.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.userservice.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionhandler {
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<APIResponse> handlerResourseNotFoundException(ResourseNotFoundException ex){
		String message = ex.getMessage();
		APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
		
	}

}
