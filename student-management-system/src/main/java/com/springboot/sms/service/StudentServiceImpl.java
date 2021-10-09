package com.springboot.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.sms.dao.StudentDAO;
import com.springboot.sms.entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	private StudentDAO studentDAO;
	
	

	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}



	@Override
	public List<StudentEntity> getAllStudents() {
		return studentDAO.findAll();
	}



	@Override
	public void save(StudentEntity entity) {
		studentDAO.save(entity);
		
	}



	@Override
	public StudentEntity getStudentById(Long id) {
		
		return studentDAO.findById(id).get();
	}



	public StudentEntity updateStudent(Long id,StudentEntity student) {
		StudentEntity existingStudent = studentDAO.findById(id).orElse(null);
		
		if(existingStudent!=null) {
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
		return studentDAO.save(existingStudent);
		}
		else {
			return null;
		}
	}



	@Override
	public void deleteStudentById(Long id) {
		
		studentDAO.deleteById(id);
		
		
	}

}
