package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByAttendence(boolean b);
	
}

