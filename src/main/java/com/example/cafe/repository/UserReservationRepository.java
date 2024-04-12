package com.example.cafe.repository;

import com.example.cafe.entity.UserReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReservationRepository extends JpaRepository<UserReservationEntity, Long> {
//    @Query("SELECT c.name,SUM(CASE WHEN tte.isUsing = false THEN tte.seatCount ELSE 0 END), SUM(tte.seatCount) " +
//            "FROM CafeEntity c " +
//            "JOIN c.cafeSectorEntity.tableTemplateEntity tte " +
//            "WHERE c.idx = :idx")

    //카페 메뉴를 바로 예약 테이블이랑 매칭시켰을 경우 > 해당 메뉴의 id는 특정 카페에만 있기 때문에 카페가 특정된다.
    //카페를 예약 테이블과 매칭했을 경우 > 어느 카페를 예약했는지 알지만 어느 메뉴를 시켰는지를 모른다.
    //아니면 사용자가 특정 테이블과 메뉴를 선택 하면 어느 카페에서 예약을 했는지 특정은 된다 그럼 예약 테이블에 있는 cafeId는

    @Query("SELECT ure.id, " +
            "ure.cafeMenuEntity.cafeEntity.name, " +
            "ure.tableTemplateEntity.seatNo, " +
            "ure.cafeMenuEntity.name, " +
            "FROM UserReservationEntity ure where ure.userEntity.idx = :idx")

//    @Query("SELECT ur.idx, ur.req, ur.res " +
//            "FROM UserReservationEntity ur " +
//            "JOIN ur.tableTemplateEntity.cafeSectorEntity.cafeEntity c " + //유저가 선택한 테이블을 알면 그이후는 따라온다
//            "JOIN ur.userEntity u " +
//            "JOIN ur.tableTemplateEntity tt " +
//            "WHERE u.idx = :idx")//유저의 아이디값에 대해
    List<?> findByUserIdx(@Param(value = "idx") Long idx);

    /**
     * 예약 테이블에서
     * 유저 아이디
     * 카페 아이디
     * 카페 메뉴 아이디
     * 테이블 넘버
     * 가능하면 테이블의 구역 아이디 까지
     */

    /**
     * cafe_info가 제일 우측에 있을 경우
     * 해당 카페에 전체 좌석 수를 출력하고 싶다
     *
     */
}
