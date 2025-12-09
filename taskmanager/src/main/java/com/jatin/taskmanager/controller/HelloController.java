package com.jatin.taskmanager.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/taskmanager")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Task Manager App is Running!";
    }
}


