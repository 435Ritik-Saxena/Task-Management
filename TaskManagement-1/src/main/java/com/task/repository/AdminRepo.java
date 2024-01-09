package com.task.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

}
