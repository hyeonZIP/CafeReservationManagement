package com.example.cafe.repository;

import com.example.cafe.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /*
    이메일 중복 확인
     */
    Boolean existsByUsername(String username);

    /*
    이름을 통해 특정 유저 확인
     */
    UserEntity findByUsername(String username);



}
