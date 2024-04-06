package com.example.cafe.repository;

import com.example.cafe.entity.TableTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTemplateRepository extends JpaRepository<TableTemplateEntity, Long> {
}
