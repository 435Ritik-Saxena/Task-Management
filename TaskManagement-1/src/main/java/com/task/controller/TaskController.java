package com.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.task.entities.Task;
import com.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskapp")
@CrossOrigin(origins="*")
public class TaskController {

	 @Autowired
    private TaskService taskService;

   
	 @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getalltasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

	 @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/gettask/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable int taskId) {
        Optional<Task> task = taskService.getTaskById(taskId);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

	 @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/taskname/{taskName}")
    public ResponseEntity<Task> getTaskByTaskName(@PathVariable String taskName) {
        Optional<Task> task = taskService.getTaskByTaskName(taskName);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

	 @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addnewtask")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
            taskService.saveTask(task);
            return new ResponseEntity<>("Task saved successfully",HttpStatus.CREATED);
        
    }

	 @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updatetask/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable int taskId, @RequestBody Task updatedTask) {
       
             taskService.updateTask(taskId, updatedTask);
             return new ResponseEntity<> ("Task updated successfully",HttpStatus.OK);
           
        
    }

	 @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletetask/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        
            taskService.deleteTask(taskId);
            return new ResponseEntity<> ("Task deleted successfully",HttpStatus.OK);
       
    }
}
