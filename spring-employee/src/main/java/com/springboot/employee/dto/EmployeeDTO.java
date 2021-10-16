package com.springboot.employee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="employee_tablee")
public class EmployeeDTO {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="NAME")
	private String name;
	@Column(name ="AGE")
	private String age;
	@Column(name ="MOBILE")
	private String mobile;
	
	

}
