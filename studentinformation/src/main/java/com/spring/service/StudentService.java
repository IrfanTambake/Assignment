package com.spring.service;

 import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;

import com.spring.dto.StudentDTO;
import com.spring.entity.Student;
@ComponentScan
public interface StudentService {
		
		public StudentDTO createstudent (Student student);
		
		public Optional<Student> getStudent(long id);
		
		public Student updateStudent(Student student);
		
		public void deleteStudent(long id);
		
		public void deleteAll();
		
		public List<StudentDTO> getAllStudents();
		
		public List<Student> presentStudent();

		Student updaStudent(Student student);
		
}
