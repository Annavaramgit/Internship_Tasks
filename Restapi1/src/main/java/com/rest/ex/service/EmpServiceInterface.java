package com.rest.ex.service;

import java.util.List;

import com.rest.ex.entity.Emp;

public interface EmpServiceInterface {
	
	public Emp saveEmp(Emp emp);
	
	public void deleteEmp(Emp emp);
	
	public Emp updateEmp(Emp emp);
	
	public Emp findById(int id);
	
	public List<Emp> findAll();
	


}
