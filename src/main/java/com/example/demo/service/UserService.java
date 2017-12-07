package com.example.demo.service;

import com.example.demo.domain.SysUser;
import org.springframework.stereotype.Service;

@Service("userService")
public interface UserService {
    SysUser findByName(String name);
}
