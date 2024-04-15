package com.example.cafe.repository;

import com.example.cafe.dto.CafeSeatDto;
import com.example.cafe.entity.CafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CafeRepository extends JpaRepository<CafeEntity, Long>
{
    //카페이름, 카페 전체 좌석, 카페 여석
    @Query("SELECT new com.example.cafe.dto.CafeSeatDto(c.idx,c.name,SUM(CASE WHEN tte.isUsing = false THEN tte.seatCount ELSE 0 END), SUM(tte.seatCount)) " +
            "FROM CafeEntity c " +
            "JOIN c.cafeSectorEntity.tableTemplateEntity tte " +
            "WHERE c.idx = :idx")
    Optional<List<CafeSeatDto>> findByCafeIdx(@Param(value = "idx") Long idx);


}
