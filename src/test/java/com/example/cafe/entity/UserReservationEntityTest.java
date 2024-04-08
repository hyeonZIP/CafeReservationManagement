package com.example.cafe.entity;

import com.example.cafe.repository.UserReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserReservationEntityTest {

    @Autowired
    UserReservationRepository userReservationRepository;

    @Test
    void setUserReservationRepository()
    {
        userReservationRepository.save(UserReservationEntity.builder().build());
    }
}