package com.jatin.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManager {

	public static void main(String[] args) {
		System.out.println("Hello from main");
		SpringApplication.run(TaskManager.class, args);
	}

}
