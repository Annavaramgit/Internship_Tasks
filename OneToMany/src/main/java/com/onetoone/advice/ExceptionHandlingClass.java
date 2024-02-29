package com.onetoone.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onetoone.exception.NoCustomerIsFound;

@RestControllerAdvice
public class ExceptionHandlingClass extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,Object>>  validation(MethodArgumentNotValidException er)
	
	{
		
		Map<String,Object> map = new HashMap<>();
	
		er.getBindingResult().getFieldErrors().forEach(error ->{
			
			map.put(error.getField(),error.getDefaultMessage());
		});
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	
	//handling nocustomer there if user fetch invalid customer fetching operation
	@ExceptionHandler(NoCustomerIsFound.class)
	public ResponseEntity<Map<String,Object>> validation1(NoCustomerIsFound err)
	{
	Map<String,Object> map = new HashMap<>();
	map.put("Error Is::", err.getMessage());
	map.put("Status",HttpStatus.BAD_REQUEST.value());

	return new ResponseEntity<Map<String,Object>>(map, HttpStatus.BAD_REQUEST);
	}
}
