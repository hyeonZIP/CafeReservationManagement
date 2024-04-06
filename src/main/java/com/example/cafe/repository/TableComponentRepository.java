package com.example.cafe.repository;

import com.example.cafe.entity.TableComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableComponentRepository extends JpaRepository<TableComponentEntity, Long> {
}
