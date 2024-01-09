package com.task.repository;


import com.task.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {
	
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
   // void save (User user);
	

}