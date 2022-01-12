package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Student;
import com.spring.service.StudentService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/a")
public class RestController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public Student createStud(@RequestBody Student student) {
		return service.createStudent(student);
	}
	public Student getStd(long id) {
		return null;
	}
	@PutMapping("/update")
	public Student updatestud(Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/delete")
	public String delete(Student student) {
		service.deleteStudent(student);
		return "Deleted...........";
		
	}
	@GetMapping("/all")
	public List<Student> getAll() {
		List<Student>getAllReStudents=service.getAllStudent();
		return getAllReStudents;
		
	}
}
