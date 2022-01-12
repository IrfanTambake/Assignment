package com.spring.Assignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Assignment.model.Tutorials;
import com.spring.Assignment.repositery.TutorialsRepository;

@RestController
@RequestMapping("/api")
public class TutorialsController {
	
	@Autowired
	TutorialsRepository tutorialRepository;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorials>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Tutorials> tutorials = new ArrayList<Tutorials>();
			
			if (title == null)
				tutorialRepository.findAll().forEach(tutorials::add);
			else
				tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorials> getTutorialById(@PathVariable("id") long id) {
		Optional<Tutorials> tutorialData = tutorialRepository.findById(id);
		
		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/tutrials")
	public ResponseEntity<Tutorials> createTutorials(@RequestBody Tutorials tutorials) {
		try {
			Tutorials tutorial = tutorialRepository
					.save(new Tutorials(tutorials.getTitle(), tutorials.getDescription(), tutorials.isPublished()));
			return new ResponseEntity<Tutorials>(tutorials, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Tutorials> updateTutorials(@PathVariable("id") long id, @RequestBody Tutorials tutorials) {
		Optional<Tutorials> tutorialData = tutorialRepository.findById(id);
		
		if (tutorialData.isPresent()) {
			tutorials = tutorialData.get();
			tutorials.setTitle(tutorials.getTitle());
			tutorials.setDescription(tutorials.getDescription());
			tutorials.setPublished(tutorials.isPublished());
			return new ResponseEntity<>(tutorialRepository.save(tutorials),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorials(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorials>> findByPublished() {
		try {
			List<Tutorials> tutorials = tutorialRepository.findByPublished(true);
			
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		
			}
				
		}
		
	}
	

