package com.rest1.service;

import java.util.List;

import com.rest1.dto.CustomerDto;
import com.rest1.entity.Customer;

public interface CustomerServiceInterface {
	
	public Customer saveCustomer(CustomerDto customerDto);
	
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	

}
