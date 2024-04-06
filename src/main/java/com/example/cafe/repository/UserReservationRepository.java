package com.example.cafe.repository;

import com.example.cafe.entity.UserReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReservationRepository extends JpaRepository<UserReservationEntity, Long> {
}
