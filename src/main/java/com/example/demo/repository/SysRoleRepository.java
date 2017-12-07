package com.example.demo.repository;

import com.example.demo.domain.SysRole;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRole,Long> {

     List findAll();
}
