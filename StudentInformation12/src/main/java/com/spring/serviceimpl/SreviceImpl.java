package com.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;

@Service
public abstract class SreviceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository; 
		

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);	
	}
	
	@Override
	public Student getStudent(long id) {
		Optional<Student>getOptional=studentRepository.findById(id);
		Student getStudent=getOptional.get();
		return getStudent;
	}
	@Override
	public Student updaStudent(Student student) {
		
		return null;
		
	}
	@Override
	public void deleteStudent(Student student) {
		
		studentRepository.delete(student);
	}
	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}
}

