package com.onetoone.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.dto.CustomerDto;
import com.onetoone.dto.ProducDto;
import com.onetoone.dto.ResponseDto;
import com.onetoone.entity.Customer;
import com.onetoone.entity.Product;
import com.onetoone.exception.NoCustomerIsFound;
import com.onetoone.service.CustomerServiceInterface;

import jakarta.validation.Valid;

@RestController
public class MyController {
	
	@Autowired
	private CustomerServiceInterface customerServiceInterface;
	
	
	//saving details
	@PostMapping("/task")
	public Customer savingMethod( @RequestBody @Valid CustomerDto customerDto)
	{
		return customerServiceInterface.saveCustomer(customerDto);
	}
	
	
	
	//fetching all details
	@GetMapping("/task")
	public List<Customer> fetchingMethod()
	{
		return customerServiceInterface.getAllCustomers();
	}
	
	//fetching joininformation
	@GetMapping("/fetchJoin")
	public List<ResponseDto> fetchingJoinInfo()
	{
		return customerServiceInterface.joinInfo();
	}
	
	
	
//	@PutMapping("/task/{cid}")
//	public Customer updatingCustomerMethod(@PathVariable int cid,@RequestBody @Valid CustomerDto customerDto)
//	{
//		Customer customer1=customerServiceInterface.getCustomerById(cid);
//		CustomerDto customerDto1=new CustomerDto();
//		customerDto1.setCname(customerDto.getCname());
//		customerDto1.setCmail(customerDto.getCmail());
//		customerDto1.setProducts(customerDto.getProducts());
//		return customerServiceInterface.saveCustomer(customerDto1);
//	}
	
	//updating Customer
	@PutMapping("/task/{cid}")
	public Customer updatingCustomerMethod(@PathVariable int cid, @RequestBody @Valid CustomerDto customerDto) {
	    // Retrieve the existing customer from the database
	    Customer customer = customerServiceInterface.getCustomerById(cid);
	    if(customer==null) {throw new NoCustomerIsFound("");}
	    
	    // Update the customer with the new values from the DTO
	    customer.setCname(customerDto.getCname());
	    customer.setCmail(customerDto.getCmail());
	    
	    // Convert and set the products
	    List<Product> products = customerDto.getProducts().stream()
	                           .map(ProducDto::prepareProduct)
	                           .collect(Collectors.toList());
	    customer.setProducts(products);
	    
	    // Save the updated customer and return it
	    return customerServiceInterface.saveCustomer1(customer);
	}


	
	
	
	//deleting the customer details
	@DeleteMapping("/task/{cid}")
	public ResponseEntity<String> deletingCustomerMethod(@PathVariable int cid)
	{
		Customer customer=null;
		customer = customerServiceInterface.getCustomerById(cid);
		if(customer!=null) {
		customerServiceInterface.deleteCustomer(customer.getCid());
		
		}
		else {
			throw new NoCustomerIsFound("");
		}
	return new ResponseEntity<String>("Deleted SuccessFully ,Please Check In DB", HttpStatus.BAD_REQUEST);
		//return ResponseEntity.ok("deleted");
	}
	
	//fetching  specific customer method
	@GetMapping("/task/{cid}")
	public Customer fetchingSpecificCustomerMethod(@PathVariable int cid)
	{
		return customerServiceInterface.getCustomerById(cid);
	}

	//pagination methodm
	@GetMapping("/paginationEx/{pNo}/{Pcount}")
	public Page<Customer> paginationMethod(@PathVariable Integer pNo,@PathVariable Integer Pcount)
	{
		return customerServiceInterface.paginatinatingEx(pNo, Pcount);
	}
	
	
}
