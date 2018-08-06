package com.cyg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cyg.models.User;


public interface UserRepo extends JpaRepository<User, Long> {
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
}
