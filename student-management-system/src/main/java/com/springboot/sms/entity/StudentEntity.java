package com.springboot.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private Long id;
	@Column(name = "STUDENT_NAME")
	private String name;
	@Column(name = "AGE")
	private String age;
	@Column(name = "STUDENT_EMAIL ")
	private String email;
	
	public StudentEntity() {
		
	}
	
	public StudentEntity(String name, String age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	

}
