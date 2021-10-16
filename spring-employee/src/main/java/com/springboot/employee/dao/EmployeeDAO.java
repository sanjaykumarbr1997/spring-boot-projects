package com.springboot.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employee.dto.EmployeeDTO;

public interface EmployeeDAO extends JpaRepository<EmployeeDTO, Long >{

}
