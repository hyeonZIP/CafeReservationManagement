package com.example.cafe.repository;

import com.example.cafe.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Long> {

    public List<CafeEntity> findTop3By();

}
