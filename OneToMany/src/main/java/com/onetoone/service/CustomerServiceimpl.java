package com.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.onetoone.dto.CustomerDto;
import com.onetoone.dto.ResponseDto;
import com.onetoone.entity.Customer;
import com.onetoone.exception.NoCustomerIsFound;
import com.onetoone.repository.CustomerRepository;

@Service
public class CustomerServiceimpl implements CustomerServiceInterface {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	//saving
	@Override
	public Customer saveCustomer(CustomerDto customerDto) {

		return customerRepository.save(CustomerDto.prepareCustomer(customerDto));
	}

	//fetch all
	@Override
	public List<Customer> getAllCustomers() {
	
		return customerRepository.findAll();
	}

	//fetch few custom query
	@Override
	public List<ResponseDto> joinInfo() {
		
		return customerRepository.joinInfo();
	}

	//update
	@Override
	public Customer updateCustomer(Customer customer) {
		
		
		return customerRepository.save(customer);
	}

	//fetch specific customer
	@Override
	public Customer getCustomerById(int id) {
		
		Customer c= customerRepository.findById(id).orElseThrow(() -> new NoCustomerIsFound("No Customer Found At ::"+id));
			return c;	
	}

	//delete by usning cid
	@Override
	public void deleteCustomer(int cid) {
		
		customerRepository.deleteById(cid);
	}
	
	//update
	@Override
	public Customer saveCustomer1(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Page<Customer> paginatinatingEx(Integer pNo, Integer Pcount) {
	Pageable pageable = PageRequest.of(pNo, Pcount);
		return customerRepository.findAll(pageable);
	}

	

	

}
