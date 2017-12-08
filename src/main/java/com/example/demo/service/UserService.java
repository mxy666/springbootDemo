package com.example.demo.service;

import com.example.demo.domain.SysUser;
import com.example.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserService {

    @Autowired
    SysUserRepository sysUserRepository;
   public SysUser findByName(String name){

     return   sysUserRepository.findByName(name);

   }
}
