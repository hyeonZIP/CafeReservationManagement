package com.example.cafe.repository;

import com.example.cafe.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Long>
{
    //카페이름, 카페 전체 좌석, 카페 여석
    @Query("SELECT c.name,SUM(CASE WHEN tte.isUsing = false THEN tte.seatCount ELSE 0 END), SUM(tte.seatCount) " +
            "FROM CafeEntity c " +
            "JOIN c.cafeSectorEntity.tableTemplateEntity tte " +
            "WHERE c.idx = :idx")
    List<?> findByCafeIdx(@Param(value = "idx") Long idx);


}
