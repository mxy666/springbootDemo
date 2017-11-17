package com.example.demo.web.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private   UserRepository userRepository;

    @GetMapping("/user/{id}")
    public  User getUser(@PathVariable(value = "id")long id){
        User user=userRepository.findById(id);
        return user;
    }

    @GetMapping("/user/byName")
    public List<User> getUserByName(@RequestParam(value = "name")String  name){
        List<User> user=userRepository.findByName(name);
        return user;
    }
}
