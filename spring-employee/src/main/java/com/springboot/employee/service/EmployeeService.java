package com.springboot.employee.service;

import java.util.List;

import com.springboot.employee.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO saveEmployee(EmployeeDTO employee);
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getEmployeeById(long id);
	EmployeeDTO updateEmployee(EmployeeDTO employee,long id);
	void deleteEmployee(long id);
}
