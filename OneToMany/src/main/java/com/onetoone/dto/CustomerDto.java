package com.onetoone.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.onetoone.entity.Product;


import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.onetoone.entity.Customer;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	@NotEmpty(message= "Should Not Live As Empty")
	@NotNull(message = "Should Not A Empty")
	private String cname;
	@Email(regexp = "^(.+)@(.+)$",message = "must be email formate")
	@NotEmpty(message= "Should Not Live As Empty")
	@NotNull(message = "Should Not A Empty")
	private String cmail;
	
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "cid", name = "Customer_id")
	@Valid
	@NotEmpty(message = "Products list should not be empty")
	private List<ProducDto> products;

	
	//chat
	public static Customer prepareCustomer(CustomerDto customerDto) {
	    Customer customer = new Customer();
	    customer.setCname(customerDto.getCname());
	    customer.setCmail(customerDto.getCmail());
	    
	    List<Product> products = customerDto.getProducts().stream()
	                           .map(ProducDto::prepareProduct)
	                           .collect(Collectors.toList());
	    
	    customer.setProducts(products);
	    
	    return customer;
	}

	
//	//chat
//	public static CustomerDto fromCustomer(Customer customer) {
//	    CustomerDto customerDto = new CustomerDto();
//	    customerDto.setCname(customer.getCname());
//	    customerDto.setCmail(customer.getCmail());
//	    customerDto.setProducts(customer.getProducts().stream()
//	                              .map(ProducDto::fromProduct)
//	                              .collect(Collectors.toList()));
//	    return customerDto;
//	}

	
}
