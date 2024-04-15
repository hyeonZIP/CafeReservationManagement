package com.example.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReservationDto {
    private Long reservationIdx; //예약 ID
    private String userRealName; //사용자 이름
    private String cafeName; //카페 이름
    private Integer seatNo; //테이블 넘버
    private String sectorName; //테이블 구역 이름
    private LocalDateTime req; //예약 요청 시간
    private LocalDateTime res; //예약 응답 시간

    //ur.idx, u.realname, c.name, tt.seatNo, cs.name, cm.name, mo.count, ur.req, ur.res
}
