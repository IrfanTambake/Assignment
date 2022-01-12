package com.spring.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.StudentDTO;
import com.spring.entity.Student;
import com.spring.service.StudentService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
	
	@Autowired
	private StudentService Service;
	
	@PostMapping("/create")
	public StudentDTO createStud(@RequestBody Student Student) {
		StudentDTO std = Service.createstudent(Student);
		return std;
		
	}
// @GetMapping("/all/{id}")
// public Student getStd(@Pathvariable long id){
//		return service.getStuendt(id);
//}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Student> getStd(@PathVariable long id) throws EntityNotFoundException {
		Student students = Service.getStudent(id)
				.orElseThrow(() -> new EntityNotFoundException("User Not Found......Plz Check Id : " + id));
		return ResponseEntity.ok().body(students);
	}
	@PutMapping("/update")
	public Student updatestud(Student student) {
		return Service.updateStudent(student);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		Service.deleteStudent(id);
		return "Deleted...........";
	}
	
	@DeleteMapping("/delete/all")
	public String deleteAll() {
		Service.deleteAll();
		return "All Data Deleted.......";
	}
	
	@GetMapping("/all")
	public List<StudentDTO> getAll(){
		List<StudentDTO> getAllstudents = Service.getAllStudents();
		return getAllstudents;
	}
	@GetMapping("/present")
	public List<Student> preseStudents() {
		List<Student> preStudent = Service.presentStudent();
		return preStudent;
	}
}
