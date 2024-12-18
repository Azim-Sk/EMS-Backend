package com.springboot.ems.mapper;

import com.springboot.ems.dto.EmployeeDTO;
import com.springboot.ems.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDTO mapToEmployeeDto(Employee employee) {
		return new EmployeeDTO(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail());
	}
	
	public static Employee mapToEmployee(EmployeeDTO empDTO) {
		return new Employee(
				empDTO.getId(),
				empDTO.getFirstName(),
				empDTO.getLastName(),
				empDTO.getEmail());
	}

}
