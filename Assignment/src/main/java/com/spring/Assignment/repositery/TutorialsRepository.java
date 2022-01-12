package com.spring.Assignment.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Assignment.model.Tutorials;

public interface TutorialsRepository extends JpaRepository<Tutorials, Long> {
	List<Tutorials> findByPublished(boolean published);
	
	List<Tutorials> findByTitleContaining(String title);
	
	
	
}

