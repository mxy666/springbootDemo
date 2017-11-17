package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    List<User> findByNameAndAge(String name,String age);

    @Query(value ="select * from user where name=?1",nativeQuery = true)
    List<User> findByName(String name);
}
