package com.jatin.taskmanager.service;
import com.jatin.taskmanager.dto.TaskRequest;
import com.jatin.taskmanager.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(TaskRequest request);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id, TaskRequest request);
    void deleteTask(Long id);
}

