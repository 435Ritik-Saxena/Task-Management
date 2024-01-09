package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.Role;



public interface RoleRepo extends JpaRepository<Role,Integer>{
	
	Role findByRolename(String rolename);
}
