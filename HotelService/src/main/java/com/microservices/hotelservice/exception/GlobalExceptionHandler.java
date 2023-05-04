package com.microservices.hotelservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;





@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<Map<String,Object>> handleResourseNotFoundException(ResourceNotFoundException ex){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", ex.getMessage());
		map.put("scccess", false);
		map.put("HttpStatus", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
