package com.example.cafe.entity;

import com.example.cafe.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserEntityTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void signupTest()
    {
        userRepository.save(UserEntity.builder().password("qwer").email("aminez@gmail.com").name("david").build());
    }

    @Transactional
    @Test
    void findEmail() {
        var userEntity = userRepository.findByEmail("aminez@gmail.com").get();
        System.out.println(userEntity);
    }
}