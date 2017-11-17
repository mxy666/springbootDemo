package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private com.example.demo.repository.UserRepository userRepository;


    /**
     * 测试repository
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Gson gson=new GsonBuilder().create();
        System.out.print(gson.toJson(userRepository.findById(1L)));
    }
}
