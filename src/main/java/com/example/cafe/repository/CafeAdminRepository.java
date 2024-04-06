package com.example.cafe.repository;

import com.example.cafe.entity.CafeAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeAdminRepository extends JpaRepository<CafeAdminEntity, Long> {
}
