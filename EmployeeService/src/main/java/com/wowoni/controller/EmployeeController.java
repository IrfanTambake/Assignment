package com.wowoni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowoni.entity.Employee;
import com.wowoni.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;
	
	@GetMapping("getEmp")
	public List<Employee> getEmployeeTest() {
		return employeeService.getAllEmployee();
	}
	@PostMapping("addEmp")
	public Employee addEmployee(Employee employee) {
		return employeeService.addEmployee(employee);
	}
    @PutMapping
    public void updateEmployee(Employee employee) {
    	employeeService.updateEmployee(employee);
    }
    @DeleteMapping("deleteEmp/{id}")
    public void deleteEmployee(@PathVariable Long id) {
    	employeeService.deleteEmployee(id);
    }
}
