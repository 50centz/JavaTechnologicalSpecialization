package ru.geekbrains.seminar3HomeTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.seminar3HomeTask.models.User;
import ru.geekbrains.seminar3HomeTask.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private TaskService taskService;


    @GetMapping("/sort")
    public List<User> sortUsersByAge(){
        return taskService.sortUsersByAge();
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        return taskService.filterUsersByAge(age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge(){
        return taskService.calculateAverageAge();
    }
}
