package ru.geekbrains.seminar3HomeTask.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.seminar3HomeTask.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private List<User> users;

    public UserRepository(){
        this.users = new ArrayList<>();
    }


    public void addUser(User user){
        users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }
}
