package com.example.cafe.controller;

import com.example.cafe.dto.CafeSeatDto;
import com.example.cafe.dto.UserReservationDto;
import com.example.cafe.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;

    /**
     * 조건에 해당하는 카페들의 이름과 좌석 리턴
     */
    @GetMapping("/cafe")
    public List<CafeSeatDto> findByCafeIdx(@RequestParam(name = "idx") Long idx)
    {
        log.info("idx={}", idx);
//        homeService.save();

        return homeService.findByCafeIdx(idx);
    }

    /**
     *  유저 아이디를 통해
     *  주문한 음료 리스트 리턴
     */
    @GetMapping("/reservation")
    public UserReservationDto findByUserIdx(@RequestParam(name = "idx") Long idx)
    {
        log.info("idx={}", idx);
        return homeService.findByUserIdx(idx);
    }
}
