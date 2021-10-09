package com.springboot.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sms.entity.StudentEntity;

public interface StudentDAO extends JpaRepository<StudentEntity, Long> {

}
 