package com.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.AssociationOverride;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.StudentDTO;
import com.spring.entity.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;

@Service
public abstract class SreviceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	final static Logger Logger = LogManager.getLogger(SreviceImpl.class);
	
	@Override
	public StudentDTO createstudent (Student student) {
		Logger.info("USer Acess Create Student Method");
		Student stdStudent = studentRepository.save(student);
		StudentDTO studentDTO = modelMapper.map(stdStudent, StudentDTO.class);
		Logger.info("Student Sucessescully Created");
		return studentDTO;
		
	}
	@Override
	public Optional<Student> getStudent(long id) {
		Optional<Student> getOptional = studentRepository.findById(id);
		return getOptional;
	}
	public void deleteStudent(long id) {
		try {
			studentRepository.deleteById(id);
		} catch (Exception e) {
			Logger.error("ID Not Found....");
		}
	}
	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> list = new ArrayList<>();
		list = studentRepository.findAll();
		List<StudentDTO> responseDto = list.stream().map(student -> modelMapper.map(student, StudentDTO.class))
				.collect(Collectors.toList());
				
		return responseDto;
	}
	@Override
	public void deleteAll() {
		studentRepository.deleteAll();
		
	}
	@Override
	public Student updaStudent(Student student) {
		long id = student.getId();
		com.spring.entity.Student upaStudent = studentRepository.findById(id).get();
		upaStudent.setStdName(student.getStdName());
		upaStudent.setRollNo(student.getRollNo());
		return studentRepository.save(upaStudent);
	}
	public List<Student> presentStudents() {
		List<Student> students = studentRepository.findByAttendence(true);
		return students;
	}
			
	}

