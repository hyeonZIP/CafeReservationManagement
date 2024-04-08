package com.example.cafe.service;

import com.example.cafe.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void findallTest()
    {
        System.out.println(userRepository.findAll());
    }
}