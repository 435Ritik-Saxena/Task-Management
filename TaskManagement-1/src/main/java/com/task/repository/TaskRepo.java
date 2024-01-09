package com.task.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.Task;

public interface TaskRepo  extends JpaRepository<Task,Integer>{
	Optional<Task> findByTitle(String title);

}