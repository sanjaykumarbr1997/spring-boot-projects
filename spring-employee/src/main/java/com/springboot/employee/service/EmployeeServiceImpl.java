package com.springboot.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.employee.dao.EmployeeDAO;
import com.springboot.employee.dto.EmployeeDTO;
import com.springboot.employee.exceptions.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO;
	
	

	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}



	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employee) {
		return employeeDAO.save(employee);
	}



	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeDAO.findAll();
	}



	@Override
	public EmployeeDTO getEmployeeById(long id) {
//		Optional<EmployeeDTO> employee = employeeDAO.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("EmployeeDTO", "iD", id);
//		}
//	}
		return employeeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmployeeDTO", "Id", id) );
	}



	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employee, long id) {
		//check employee id in database 
		EmployeeDTO existingEmployee = employeeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmployeeDTO","Id", id));
		existingEmployee.setName(employee.getName());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setMobile(employee.getMobile());
		
		employeeDAO.save(existingEmployee);
		
		return null;
	}



	@Override
	public void deleteEmployee(long id) {
		
		//check whether a employee exist in DB Or  not
		employeeDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmployeeDTO", "Id", id));
		employeeDAO.deleteById(id);
		
	}
}
