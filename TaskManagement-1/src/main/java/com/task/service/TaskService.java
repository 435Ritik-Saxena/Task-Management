package com.task.service;

import org.springframework.data.domain.Page;

//import com.monocept.insurance.dto.AllSchemeDto;
import com.task.entities.Task;
import java.util.*;


public interface TaskService {
	
	//Task saveTask(Task task,int taskid);
 //	Page<AllSchemeDto> getAllSchemes(int planid, int pageno, int pagesize);
	//String updateTask(Task task,int taskid);
	
	 List<Task> getAllTasks();

	    Optional<Task> getTaskById(int taskId);

	    Optional<Task> getTaskByTaskName(String taskName);

	    Task saveTask(Task task);

	    Task updateTask(int taskId, Task task);

	    void deleteTask(int taskId);

}
