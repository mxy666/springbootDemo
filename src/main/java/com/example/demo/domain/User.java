package com.example.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * create by mxy 2017
 */
@Entity
public class User implements Serializable{

    private Long id;

    @Column
    private String name;


    private int age;


    private int state;

    public User() {
    }

    public User(String name, int age, int state) {
        this.name = name;
        this.age = age;
        this.state = state;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
