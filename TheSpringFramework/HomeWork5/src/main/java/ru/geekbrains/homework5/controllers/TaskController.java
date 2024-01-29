package ru.geekbrains.homework5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework5.models.Task;
import ru.geekbrains.homework5.services.TaskServices;


@Controller
@AllArgsConstructor
public class TaskController {

    private TaskServices taskServices;
    @GetMapping("/")
    public String homePage(){
        return "index.html";
    }

    @GetMapping("/task-create")
    public String createTask(){
        return "task-create.html";
    }

    @PostMapping("/task-create")
    public String createTask(Task task){
        taskServices.createTask(task);
        return "redirect:/";
    }

    @GetMapping("/view-all-tasks")
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskServices.getAllTasks());
        return "view-all-tasks.html";
    }

    @GetMapping("/viewing-tasks-by-status/{status}")
    public String getTasksByStatus1(@PathVariable("") int status, Model model){
        model.addAttribute("tasks", taskServices.findTasksByStatus(status));
        return "tasks-by-status.html";
    }


    @GetMapping("/task-update/{id}")
    public String updateTaskById(Task task){

        return "update-task.html";
    }

    @PostMapping("/task-update")
    public String updateTask(Task task){
        taskServices.updateTaskById(task);
        return "redirect:/view-all-tasks";
    }

    @GetMapping("/task-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        taskServices.deleteById(id);
        return "redirect:/view-all-tasks";
    }




}
