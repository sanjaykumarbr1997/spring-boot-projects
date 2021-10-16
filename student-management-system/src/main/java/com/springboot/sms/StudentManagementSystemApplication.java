package com.springboot.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.springboot.sms.dao.StudentDAO;
import com.springboot.sms.entity.StudentEntity;

@SpringBootApplication
public class StudentManagementSystemApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	
//	@Autowired
//	private StudentDAO studentDAO;
//	@Override
//	public void run(String... args) throws Exception {
		
//		StudentEntity student1 = new StudentEntity("Ramesh","25","snjku@gmail.com");
//		studentDAO.save(student1);
//		
//		StudentEntity student2 = new StudentEntity("Suresh","25","suresh@gmail.com");
//		studentDAO.save(student2);
//		
//		StudentEntity student3 = new StudentEntity("Tony","25","tont@gmail.com");
//		studentDAO.save(student3);
		
		 
	//}

}
