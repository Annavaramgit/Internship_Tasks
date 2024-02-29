package com.onetoone.dto;

import java.util.List;

import com.onetoone.entity.Product;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProducDto {
	
	@Id
	 @NotNull(message = "Should Not Live As Empty")
    private Integer pid;
	
	@NotBlank(message = "Should Not Live As Empty")
    private String pname;
	@NotNull(message = "Should Not A Empty")
    private Double pprice;
	
	//chat
	 public Product prepareProduct() {
	        Product product = new Product();
	        product.setPid(this.pid);
	        product.setPname(this.pname);
	        product.setPprice(this.pprice);
	        return product;
	    }
	
}
