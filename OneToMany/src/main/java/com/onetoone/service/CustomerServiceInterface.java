package com.onetoone.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.onetoone.dto.CustomerDto;
import com.onetoone.dto.ResponseDto;
import com.onetoone.entity.Customer;

public interface CustomerServiceInterface {
	public Customer saveCustomer(CustomerDto customerDto);
	
	public List<Customer> getAllCustomers();
	
	public List<ResponseDto> joinInfo();
	
	public  Customer updateCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
	public void deleteCustomer(int cid);
	
	public Customer saveCustomer1(Customer customer);

	public Page<Customer> paginatinatingEx(Integer pNo,Integer Pcount);
}
