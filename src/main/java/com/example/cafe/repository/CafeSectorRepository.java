package com.example.cafe.repository;

import com.example.cafe.dto.CafeSectorDto;
import com.example.cafe.dto.TableTemplateDto;
import com.example.cafe.entity.CafeSectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeSectorRepository extends JpaRepository<CafeSectorEntity, Long> {

    @Query("SELECT new com.example.cafe.dto.CafeSectorDto(cse.idx, cse.name, cse.sizeX, cse.sizeY) " +
            "FROM CafeSectorEntity cse " +
            "WHERE cse.cafeEntity.idx = :idx")
    List<CafeSectorDto> findByCafeIdx(@Param(value = "idx") Long idx);

    @Query("SELECT new com.example.cafe.dto.TableTemplateDto(tte.idx, tte.seatCount, tte.seatNo, tte.seatX, tte.seatY, tte.description, tte.isUsing, tce.idx, tce.name) " +
            "FROM TableTemplateEntity tte " +
            "JOIN tte.tableComponentEntity tce " +
            "WHERE tte.cafeSectorEntity.idx = :idx")
    List<TableTemplateDto> findByCafeSectorIdx(@Param(value = "idx") Long idx);
}
