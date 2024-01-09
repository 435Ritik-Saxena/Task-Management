package com.task.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.task.exception.NullValueException;
import com.task.entities.Task;

import com.task.exception.UserApiException;

import com.task.repository.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> getTaskById(int taskId) {
        return taskRepo.findById(taskId);
    }

    @Override
    public Optional<Task> getTaskByTaskName(String title) {
        return taskRepo.findByTitle(title);
    }

    @Override
    public Task saveTask(Task task) {
        if (taskRepo.findByTitle(task.getTitle()).isPresent()) {
            throw new UserApiException(HttpStatus.BAD_REQUEST,"Task Already Exists");
        }
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(int taskId, Task updatedTask) {
        Optional<Task> existingTask = taskRepo.findById(taskId);
        if (existingTask.isPresent()) {
            Task taskToUpdate = existingTask.get();
            taskToUpdate.setTitle(updatedTask.getTitle());
            taskToUpdate.setDescription(updatedTask.getDescription());
            taskToUpdate.setStartDate(updatedTask.getStartDate());
            taskToUpdate.setCompleteDate(updatedTask.getCompleteDate());
            taskToUpdate.setPriority(updatedTask.getPriority());
            taskToUpdate.setStatus(updatedTask.getStatus());
            return taskRepo.save(taskToUpdate);
        } else {
            throw new NullValueException("No Task with this id is present",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTask(int taskId) {
        if (taskRepo.existsById(taskId)) {
            taskRepo.deleteById(taskId);
        } 
        else {
        	 throw new NullValueException("No Task with this id is present",HttpStatus.NOT_FOUND);
        }
    }

}
