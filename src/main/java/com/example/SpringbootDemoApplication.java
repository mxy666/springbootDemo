package com.example;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.example.demo.support.Appctx;
import com.example.demo.support.MyFilterSecurityInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = MyFilterSecurityInterceptor.class)
public class SpringbootDemoApplication {


	private static final Logger log = LoggerFactory.getLogger(SpringbootDemoApplication.class);
	@PostConstruct
	public void initApplication() throws IOException {
		log.info("Running with Spring profile(s) : {}");
	}

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootDemoApplication.class, args);
		SpringApplication app=new SpringApplication(SpringbootDemoApplication.class);
		Appctx.ctx=app.run(args);
        /*UserService suserService = (UserService) Appctx.ctx.getBean("suserService");
        SysUser su= suserService.findByName("user");
        System.out.println("密码"+su.getPassword());
        System.out.println("名字"+su.getName());
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);//将密码加密
        su.setPassword(bc.encode(su.getPassword()));
        System.out.println("密码"+su.getPassword());
        suserService.update(su);*/
	}
}
