package com.example;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository {
	
	public interface UserRepositiry extends JpaRepository<User, Long> {
		
	}

}
