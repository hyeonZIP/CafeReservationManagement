package com.example.cafe.entity;

import com.example.cafe.repository.CafeAdminRepository;
import com.example.cafe.repository.CafeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CafeEntityTest {

    @Autowired
    CafeRepository cafeRepository;

    @Autowired
    CafeAdminRepository cafeAdminRepository;

    @Test
    void insertCafe()
    {

//        cafeAdminRepository.save(CafeAdminEntity.builder()
//                .cafe_admin_pw("123456")
//                .cafe_admin_email("test@gmail.com")
//                .cafe_admin_name("admin").build());

        cafeRepository.save(CafeEntity.builder()
                .name("starbucks")
                .cafeAdminEntity(CafeAdminEntity.builder().idx(1L).build()).build());
    }
}