package com.example.cafe.repository;

import com.example.cafe.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByEmail(String email);

    public Optional<UserEntity> findByEmailAndPassword(String email, String password);

}
