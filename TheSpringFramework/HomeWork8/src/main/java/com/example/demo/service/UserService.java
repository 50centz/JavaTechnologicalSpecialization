package com.example.demo.service;

import com.example.demo.aspects.TrackUserAction;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    @TrackUserAction
    public void updateS(User user){
        userRepository.updateR(user);
    }
}
