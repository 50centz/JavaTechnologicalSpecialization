package ru.geekbrains.seminar3HomeTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.seminar3HomeTask.models.User;
import ru.geekbrains.seminar3HomeTask.services.NotificationService;
import ru.geekbrains.seminar3HomeTask.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;


    @PostMapping("/body")
    public String userAdd(@RequestBody User user){
        userService.userAdd(user);
        return notificationService.userAdd(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }


}
