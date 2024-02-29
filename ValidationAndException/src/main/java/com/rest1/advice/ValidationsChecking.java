package com.rest1.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest1.exception.NoCutsomerThere;

@RestControllerAdvice
public class ValidationsChecking extends Exception {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> validation(MethodArgumentNotValidException er)
	{
		Map<String,String> map = new HashMap<>();
	
		er.getBindingResult().getFieldErrors().forEach(error ->{
			map.put(error.getField(),error.getDefaultMessage());
		});
		
		return map;
	}
	@ExceptionHandler(NoCutsomerThere.class)
	public Map<String,String> validation1(NoCutsomerThere err)
	{
		Map<String,String> map = new HashMap<>();
		map.put("error is:", err.getMessage());
		return map;
	}
	
}
