package com.example.cafe.repository;

import com.example.cafe.entity.CafeEntity;
import com.example.cafe.entity.CafeSectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeSectorRepository extends JpaRepository<CafeSectorEntity, Long> {

    List<CafeSectorEntity> findByCafeEntity(CafeEntity entity);
}
