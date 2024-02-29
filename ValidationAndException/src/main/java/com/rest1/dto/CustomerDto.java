package com.rest1.dto;

import com.rest1.entity.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	@NotEmpty(message= "Should Not Live As Empty")
	@NotNull(message = "Should Not A Empty")
	private String name;
	@Email
	@NotEmpty
   @NotBlank
	private String email;
	

	
	public static Customer prepareCustomer(CustomerDto customerDto)
	{
		Customer customer  = new Customer();
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
	
		return customer;
		
	}
	
	
}
