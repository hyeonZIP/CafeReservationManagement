package com.example.cafe.repository;

import com.example.cafe.entity.CafeMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeMenuRepository extends JpaRepository<CafeMenuEntity, Long> {
}
