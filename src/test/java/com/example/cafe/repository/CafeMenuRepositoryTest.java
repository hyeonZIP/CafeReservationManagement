package com.example.cafe.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeMenuRepositoryTest {

    @Autowired
    CafeMenuRepository cafeMenuRepository;
    @Test
    void findByCafeIdx() {
        cafeMenuRepository.findByCafeIdx(1L);
    }
}