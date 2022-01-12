package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import models.User;

@Service
public class UserService {
	
	
	List<User> list = new ArrayList<>();
	private String Username;
	private String Password;
	private String email;
	
	public UserService() {
		list.add(new User(Username: "xyz", Password: "abc", email: "IRFAN@GMAIL.com"));
		list.add(new User(Username: "rnx", Password: "xyz", email: "XYZ@GMAIL.com"));
	}
	
	//get all users
	public List<User> getAllUsers() { return this.list; }
	
	//get single user
	public User getUser(String username)
	{
		return this.list.stream().filter((user)->user.getUsername().equals(username).findAny().orElse(other: null));
	}
	
	
	//add new user
	public User addUser(User user)
	{
		this.list.add(user);
		return user; 
	}
	


}
