package com.example;

import org.springframework.stereotype.Repository;

public interface UserProfileRepository {
	
	@Repository
	public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
		
	}

}
