package com.example.cafe.home;

import com.example.cafe.dto.CafeSeatDto;
import com.example.cafe.dto.UserReservationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HomeService {

    private final CafeRepository cafeRepository;
    private final UserReservationRepository userReservationRepository;

    //카페 이름과 좌석 조회
    public List<CafeSeatDto> findByCafeIdx(Long idx)
    {
        var dto = cafeRepository.findByCafeIdx(idx);
        return dto.orElse(Collections.emptyList());
    }

    //사용자 idx로 예약 정보 리턴
    public UserReservationDto findByUserIdx(Long idx)
    {
        var dto = userReservationRepository.findByUserIdx(idx);
        return dto.orElse(new UserReservationDto());
    }

}
