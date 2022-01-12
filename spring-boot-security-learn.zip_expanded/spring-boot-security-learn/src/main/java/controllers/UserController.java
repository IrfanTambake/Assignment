package controllers;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.User;
import services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService UserService;
	
	/// all users
	@GetMapping("/")
	public List<User> getAllUsers() { return this.UserService.getAllUsers(); }
	
	
	//return single user
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.UserService.getUser(username);
		
	}
	@PostMapping("/")
	public User add(@RequestBody User user) { return this.UserService.addUser(user); }

}

