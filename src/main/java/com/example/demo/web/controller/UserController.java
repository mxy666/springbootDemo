package com.example.demo.web.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * author mxy 2017/11/21
 * 页面跳转，使用jpa简单查询
 */

@Controller
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
    public String getById(@PathVariable(value = "id")long id, Model model){
        User user=userRepository.findById(id);
        model.addAttribute("hello",user.getName());
        return "index";
    }

    @RequestMapping("/foo")
    public String foo(Principal principal,Model model) {
        Authentication authentication = (Authentication) principal;
        model.addAttribute("test",authentication.getPrincipal().toString());
        return "test";
    }

}
