package com.example.cafe.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeRepositoryTest {

    @Autowired
    CafeRepository cafeRepository;
    @Test
    void findTop3ByCafeIdx() {
        cafeRepository.findTop3ByCafeIdx();
    }
}