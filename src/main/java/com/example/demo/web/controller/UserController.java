package com.example.demo.web.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/user/html/{id}")
    public String getById(@PathVariable(value = "id")long id,Map<String,Object> map){
        User user=userRepository.findById(id);
        map.put("hello",user.getName());
        return "index";
    }
}
