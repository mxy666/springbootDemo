package com.example.demo.security;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){

            registry.addViewController("/home").setViewName("home");
            registry.addViewController("/login").setViewName("login");
            registry.addViewController("/").setViewName("home");
            registry.addViewController("/hello").setViewName("hello");

    }
}
