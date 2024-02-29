package com.rest1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest1.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
