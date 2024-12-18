package com.springboot.ems.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ems.dto.EmployeeDTO;
import com.springboot.ems.entity.Employee;
import com.springboot.ems.exception.ResourceNotFoundException;
import com.springboot.ems.mapper.EmployeeMapper;
import com.springboot.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
		Employee emp = EmployeeMapper.mapToEmployee(employeeDto);
		Employee employeeSaved = repo.save(emp);
		
		return EmployeeMapper.mapToEmployeeDto(employeeSaved);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long employeeId) {
		Employee employee = repo.findById(employeeId).orElseThrow(() -> 
		new ResourceNotFoundException("Employee does not exists with the given id" + employeeId));;
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = repo.findAll();
		
		return employees.stream().map((e) -> EmployeeMapper.mapToEmployeeDto(e)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updateEmployee) {
		Employee employee = repo.findById(employeeId).orElseThrow(() -> 
		new ResourceNotFoundException("Employee does not exists with the given id" + employeeId));
		
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		Employee employeeUpdated = repo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(employeeUpdated);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = repo.findById(employeeId).orElseThrow(() -> 
		new ResourceNotFoundException("Employee does not exists with the given id" + employeeId));
		repo.deleteById(employeeId);
	}

}
