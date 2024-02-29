package com.rest.ex.exception;

public class NoSuchEmployeeException extends RuntimeException {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NoSuchEmployeeException(){}
	
	public NoSuchEmployeeException(String message)
	{
		super(message);
		this.message = message;
	}

}
