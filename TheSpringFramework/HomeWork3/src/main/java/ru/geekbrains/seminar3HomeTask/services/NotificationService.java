package ru.geekbrains.seminar3HomeTask.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.seminar3HomeTask.models.User;

@Service
public class NotificationService {


    public String userAdd(User user){

        return "New User has been created: " + user.getName();
    }
}
