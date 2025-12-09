package com.jatin.taskmanager.service.impl;
import com.jatin.taskmanager.dto.TaskRequest;
import com.jatin.taskmanager.model.Task;
import com.jatin.taskmanager.repository.TaskRepository;
import com.jatin.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task createTask(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        return repository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found!")
        );
    }

    @Override
    public Task updateTask(Long id, TaskRequest request) {
        Task task = getTaskById(id);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}

