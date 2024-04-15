package com.example.cafe.repository;

import com.example.cafe.dto.CafeMenuDto;
import com.example.cafe.entity.CafeMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeMenuRepository extends JpaRepository<CafeMenuEntity, Long> {

    @Query("SELECT new com.example.cafe.dto.CafeMenuDto(cme.idx, cme.name, cme.price, cme.tag) " +
            "FROM CafeMenuEntity cme " +
            "WHERE cme.cafeEntity.idx = :idx")
    List<CafeMenuDto> findByCafeIdx(@Param(value = "idx") Long idx);
}
