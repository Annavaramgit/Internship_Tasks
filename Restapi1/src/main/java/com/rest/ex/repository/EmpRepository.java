package com.rest.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.ex.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
