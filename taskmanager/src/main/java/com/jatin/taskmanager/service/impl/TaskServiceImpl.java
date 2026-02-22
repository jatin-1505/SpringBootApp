package com.jatin.taskmanager.service.impl;

import com.jatin.taskmanager.model.Task;
import com.jatin.taskmanager.dto.TaskRequest;

import com.jatin.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final DynamoDbTable<Task> taskTable;

    public TaskServiceImpl(DynamoDbEnhancedClient enhancedClient) {
        this.taskTable = enhancedClient.table(
                "TASKS",
                TableSchema.fromBean(Task.class)
        );
    }

    @Override
    public Task createTask(TaskRequest request) {
        Task task = new Task();
        task.setId(UUID.randomUUID().toString());
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.initializeDefaults();
        taskTable.putItem(task);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskTable.scan()
                .items()
                .stream()
                .toList();
    }

    @Override
    public Task getTaskById(String id) {
        Task task = taskTable.getItem(
                Key.builder()
                        .partitionValue(String.valueOf(id))
                        .build()
        );

        if (task == null) {
            throw new RuntimeException("Task not found!");
        }

        return task;
    }

    @Override
    public Task updateTask(String id, TaskRequest request) {
        Task existing = getTaskById(id);

        existing.setTitle(request.getTitle());
        existing.setStatus(request.getStatus());
        existing.setDescription(request.getDescription());

        taskTable.putItem(existing);
        return existing;
    }

    @Override
    public void deleteTask(String id) {
        taskTable.deleteItem(
                Key.builder()
                        .partitionValue(String.valueOf(id))
                        .build()
        );
    }
}

