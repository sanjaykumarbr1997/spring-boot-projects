package com.springboot.sms.service;

import java.util.List;

import com.springboot.sms.entity.StudentEntity;

public interface StudentService {
	
	List<StudentEntity> getAllStudents();

	public void save(StudentEntity entity);
	
	StudentEntity getStudentById(Long id);
	
	StudentEntity updateStudent(Long id,StudentEntity student);
	
	public void deleteStudentById(Long id);
	
	

}
