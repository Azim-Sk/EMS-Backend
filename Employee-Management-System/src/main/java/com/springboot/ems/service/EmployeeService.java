package com.springboot.ems.service;

import java.util.List;

import com.springboot.ems.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO createEmployee(EmployeeDTO empDto);
	
	EmployeeDTO getEmployeeById(Long employeeId);
	
	List<EmployeeDTO> getAllEmployees();
	
	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updateEmployeee);
	
	void deleteEmployee(Long employeeId);

}
