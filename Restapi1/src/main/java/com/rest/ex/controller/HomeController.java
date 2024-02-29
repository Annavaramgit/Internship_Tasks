package com.rest.ex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.rest.ex.entity.Emp;
import com.rest.ex.exception.NoSuchEmployeeException;
import com.rest.ex.service.EmpServiceImpl;

@RestController

public class HomeController {
	
	@Autowired
	private EmpServiceImpl empServiceImpl;
	
	@PostMapping("/example")
	public ResponseEntity<Map<String, Object>>saveEmp( @RequestBody  Emp emp)
	{
		
		 Map<String, Object>response=new HashMap<>();
		 Emp emp1=empServiceImpl.saveEmp(emp);
		 response.put("Result", emp1);
		 response.put("Status", HttpStatus.CREATED);
		 
		return new ResponseEntity(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/example/")
	public ResponseEntity<Map<String,Object>> getAll()
	{
		List<Emp> emp1 = empServiceImpl.findAll();
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("Result", emp1);
		map.put("Status","Success");
		return new  ResponseEntity(map, HttpStatus.OK);
	}
	
	@GetMapping("/example/{id}")
	public ResponseEntity<Map<String,Object>> getById( @PathVariable int id)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Emp emp1 = empServiceImpl.findById(id);
		map.put("Result", emp1);
		map.put("Status",HttpStatus.CREATED);
		return new ResponseEntity(map, HttpStatus.OK);
	}
	@PutMapping("/example/")
	public ResponseEntity<String> updateEmp(@RequestBody Emp emp)
	{
		
	Emp emp1 = empServiceImpl.updateEmp(emp);
		//return emp1;
	
	return new ResponseEntity<String>("updated",HttpStatus.OK);
		
	}
	
	@PutMapping("/example/{id}")
	public Emp updateEmp1(@PathVariable int id,@RequestBody Emp emp)
	{
		Emp emp2 = empServiceImpl.findById(id);
		emp2.setAdress(emp.getAdress());
		emp2.setName(emp.getName());
		
		
		Emp emp1 = empServiceImpl.updateEmp(emp2);
		return emp1;
	}
	
	@DeleteMapping("/example/{id}")
	public void deleteEmp(@PathVariable int id)
	{
	Emp emp1 = 	empServiceImpl.findById(id);
	empServiceImpl.deleteEmp(emp1);
	}
	
	
}
