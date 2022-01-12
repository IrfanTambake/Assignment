package com.wowoni.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowoni.entity.Employee;
import com.wowoni.reposity.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployeeData(employee.getId(), employee.getEmployeeName(), employee.getDepartment());
	}
	@Transactional
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
