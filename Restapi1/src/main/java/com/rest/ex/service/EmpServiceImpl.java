package com.rest.ex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.ex.entity.Emp;
import com.rest.ex.exception.NoSuchEmployeeException;
import com.rest.ex.repository.EmpRepository;
@Service
public class EmpServiceImpl implements EmpServiceInterface {

	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public Emp saveEmp(Emp emp) {
		Emp emp1=empRepository.save(emp);
		return emp1;
	}

	@Override
	public void deleteEmp(Emp emp) {
		empRepository.delete(emp);
	}

	@Override
	public Emp updateEmp(Emp emp) {
		Emp emp1 = empRepository.save(emp);
		return emp1;
	}

	@Override
	public Emp findById(int id) {
	Emp emp1	= empRepository.findById(id).orElseThrow(()-> new NoSuchEmployeeException("NoEmployeeFound"+id));
		
		return emp1;
	}
	    

	@Override
	public List<Emp> findAll() {
		
		List<Emp>emp=empRepository.findAll();
		return emp;
	}

}
