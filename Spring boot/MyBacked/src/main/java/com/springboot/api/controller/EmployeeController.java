package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Employee;
import com.springboot.api.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee/add")
	public Employee insertEmployee(@RequestBody Employee employee) {
		employee= employeeService.inserEmployee(employee);
		return employee;
	}
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployees(){
		List<Employee> list=employeeService.getAllEmployees();
		return list;
	}
}
