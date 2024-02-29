package com.rest.ex.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rest.ex.exception.NoSuchEmployeeException;

@ControllerAdvice
public class GlobalExceptionClass {
	
	@ExceptionHandler(NoSuchEmployeeException.class)
	public ResponseEntity<String> NosuchExeptionMethod(NoSuchEmployeeException ex)
	{
		return new ResponseEntity<String>("NoSuchEmployee There", HttpStatus.BAD_REQUEST);
	}

}
