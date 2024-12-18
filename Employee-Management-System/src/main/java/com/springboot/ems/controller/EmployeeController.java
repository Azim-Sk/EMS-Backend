package com.springboot.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ems.dto.EmployeeDTO;
import com.springboot.ems.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> creatEmployee(@RequestBody EmployeeDTO employeeDto){
		EmployeeDTO employee = service.createEmployee(employeeDto);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDTO employeeById = service.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeById);
		
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		List<EmployeeDTO> allEmployees = service.getAllEmployees();
		return ResponseEntity.ok(allEmployees);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")Long employeeId,
	@RequestBody EmployeeDTO employeeDto){
		EmployeeDTO employee = service.updateEmployee(employeeId, employeeDto);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		service.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfully!!!");
	}

}
