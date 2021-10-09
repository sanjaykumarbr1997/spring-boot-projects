package com.springboot.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.sms.entity.StudentEntity;
import com.springboot.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public ModelAndView listStudents() {
		return new ModelAndView("Students", "students", studentService.getAllStudents());
	}
	
	@GetMapping("/student/new")
	public String addDetails() {
		return "CreateStudent";
	}
	
	@GetMapping("/studentsEnroll")
	public ModelAndView createStudent(@ModelAttribute StudentEntity entity) {
		studentService.save(entity);
		return new ModelAndView("Students","students",studentService.getAllStudents());
	}
	
	
	
	@GetMapping("/studentedit/{id}")
	public ModelAndView getStudentDetails(@PathVariable Long id ) {
		return new ModelAndView("EditStudent","update", studentService.getStudentById(id));
		
	}
	
	@PostMapping("/studentsUpdate/{id}")
	public String updateDetails(@ModelAttribute StudentEntity entity ,@PathVariable Long id) {
		studentService.updateStudent(id,entity);
		return "redirect:/students";
		
	}
	
	@GetMapping("/studentedelete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	

}
