package com.onetoone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onetoone.dto.ResponseDto;
import com.onetoone.entity.Customer;
@Repository


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
@Query("select new  com.onetoone.dto.ResponseDto(c.cid,c.cname,p.pname,p.pprice) from Customer c  JOIN c.products p")
public List<ResponseDto> joinInfo();

}
