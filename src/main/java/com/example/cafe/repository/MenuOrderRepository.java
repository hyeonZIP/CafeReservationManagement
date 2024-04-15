package com.example.cafe.repository;

import com.example.cafe.entity.MenuOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuOrderRepository extends JpaRepository<MenuOrderEntity, Long> {
}
