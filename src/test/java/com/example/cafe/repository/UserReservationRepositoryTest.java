package com.example.cafe.repository;

import com.example.cafe.home.UserReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserReservationRepositoryTest {

    @Autowired
    UserReservationRepository userReservationRepository;
    @Test
    void findByUserReservationIdx() {
        userReservationRepository.findByUserReservationIdx(1L);
    }
}