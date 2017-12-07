package com.example.demo.repository;

import com.example.demo.domain.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysResourceRspository extends JpaRepository<SysResource, Long> {

        List findByRoleName(String name);
}
