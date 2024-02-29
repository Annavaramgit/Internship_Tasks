package com.rest1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest1.dto.CustomerDto;
import com.rest1.entity.Customer;

import com.rest1.service.CustomerServiceInterface;

import jakarta.validation.Valid;

@RestController
public class HomeController {
	
	@Autowired
	private  CustomerServiceInterface customerServiceInterface;
	
	@PostMapping("/validation")
	public Customer saveCustomer(@RequestBody  @Valid CustomerDto customerDto)
	{
		Customer customer = customerServiceInterface.saveCustomer(customerDto);
		return customer;
	}
	
	@GetMapping("/validation")
	public ResponseEntity<Map<String, Object>> em()
	{
		Map <String,Object>map =new HashMap<>();
		 List<Customer> all = customerServiceInterface.findAll();
		 System.out.println("------------------"+all);
		map.put("result", all);
		map.put("status",HttpStatus.CREATED.value());
		return ResponseEntity.ok(map);
		//return new ResponseEntity< List<Customer>> ( customerServiceImpl.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/validation/{id}")
	public Customer findById(@PathVariable int id)
	{
		return customerServiceInterface.findById(id);
	}

}
