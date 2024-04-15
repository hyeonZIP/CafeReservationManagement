package com.example.cafe.repository;

import com.example.cafe.entity.TableTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTemplateRepository extends JpaRepository<TableTemplateEntity, Long> {

    /**
     * 카페 id에 해당하는 sector 와 TableTemplate 가져오고, 컴포넌트도 가져온다
     *
     * 먼저 카페를 선택하면 Sector를 가져오고
     * 그 이후에 table template를 로딩한다
     * 새로운 층을 클릭 할 때마다 새롭게 디비에서 가져온다 > 실시간으로 다른 사람이 예약한결과를 반영하기 위함
     */

    //    private Long cafeId;
    //    private Long sectorId;
    //    private String sectorName;
    //    private Integer sectorSizeX;
    //    private Integer sectorSizeY;
    //    private Long tableTemplateId;
    //    private Integer seatCount;
    //    private Integer seatNo;
    //    private Integer tableTemplateX;
    //    private Integer tableTemplateY;
    //    private String tableDescription;
    //    private Boolean isUsing;
    //    private Integer componentId;
    //    private String componentName;
}
