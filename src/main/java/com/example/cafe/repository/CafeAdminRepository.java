package com.example.cafe.repository;

import com.example.cafe.entity.CafeAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CafeAdminRepository extends JpaRepository<CafeAdminEntity, Long> {

    public Optional<CafeAdminEntity> findByEmail(String email);

    public Optional<CafeAdminEntity> findByEmailAndPassword(String email, String password);
}
