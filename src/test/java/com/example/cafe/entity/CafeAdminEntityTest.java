package com.example.cafe.entity;

import com.example.cafe.repository.CafeAdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeAdminEntityTest {

    @Autowired
    CafeAdminRepository cafeAdminRepository;

    @Test
    void insertCafeAdmin()
    {
        cafeAdminRepository.save(CafeAdminEntity.builder()
                .password("1234")
                .name("LIM")
                .email("david@naver.com").build());
    }
}