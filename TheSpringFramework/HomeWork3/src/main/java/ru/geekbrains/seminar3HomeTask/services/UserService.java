package ru.geekbrains.seminar3HomeTask.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.seminar3HomeTask.models.User;
import ru.geekbrains.seminar3HomeTask.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void userAdd(User user){
        userRepository.addUser(user);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
}
