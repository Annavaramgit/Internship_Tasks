package com.rest1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest1.dto.CustomerDto;
import com.rest1.entity.Customer;
import com.rest1.exception.NoCutsomerThere;
import com.rest1.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerServiceInterface {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(CustomerDto customerDto) {
	Customer c= customerRepository.save(CustomerDto.prepareCustomer(customerDto));
	return c;
		
	}

	@Override
	public List<Customer> findAll() {
		
		 List<Customer> all = customerRepository.findAll();
		 System.out.println("************"+all);
		 return all;
	}

	@Override
	public Customer findById(int id) {
		
		Customer c=customerRepository.findById(id).orElseThrow(() -> new NoCutsomerThere("NoCustomerFound"+id));	
			return c;	
	
	}

}
