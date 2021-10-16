package com.springboot.employee.controller;

import java.util.List;

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

import com.springboot.employee.dto.EmployeeDTO;
import com.springboot.employee.service.EmployeeService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	//build create employee REST API
	@PostMapping()
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		System.out.println(employeeDTO);
		
		return new ResponseEntity<EmployeeDTO>(employeeService.saveEmployee(employeeDTO),HttpStatus.CREATED);
	}
	
	//build get all employee REST Api
	@GetMapping("users")
	public List<EmployeeDTO> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	
	//build get employee by id REST APi
	//http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
	//build update employee RestAPI
	//http://localhost:8080/api/employees/7
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") long employeeId,@RequestBody EmployeeDTO employee){
		return new ResponseEntity<EmployeeDTO>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
		
	}
	
	//build delete employee REST API
	//http://localhost:8080/api/employees/7
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee deleted succesfully", HttpStatus.OK);
	}

}
