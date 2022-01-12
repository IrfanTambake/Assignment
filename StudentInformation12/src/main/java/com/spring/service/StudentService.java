package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.entity.Student;

@Component
public interface StudentService {
	
	public Student createStudent(Student student);
	public Student getStudent(long id);
	public Student updateStudent(Student student);
	public void deleteStudent(Student student);
	public List<Student> getAllStudent();
	Student updaStudent(Student student);
	
	
	
}

	