package com.example.cafe.controller;

import com.example.cafe.dto.*;
import com.example.cafe.service.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
@RequiredArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;

    /**
     * 예약 과정
     * 1. 카페 선택
     * 2. 카페 Sector정보 리턴
     * 3. Sector의 TableTemplate정보 리턴
     * 4. 자리 선택 이후 카페 메뉴 정보 리턴
     * 5. 주문 선택 완료 시 user_reservation과 menu_order 테이블 같이 생성
     */
    @GetMapping("/sector")
    public List<CafeSectorDto> test(@RequestParam(name = "idx") Long idx)
    {
        return reserveService.findByCafeIdx(idx);
    }

    @GetMapping("/table")
    public List<TableTemplateDto> test2(@RequestParam(name="idx") Long idx)
    {
        return reserveService.findByCafeSectorIdx(idx);
    }

    @GetMapping("/cafe-menu")
    public List<CafeMenuDto> test3(@RequestParam(name = "idx") Long idx)
    {
        return reserveService.selectCafeMenu(idx);
    }

    @PostMapping("insert-reservation")
    public int insertUserReservation(ReserveDto reserveDto)
    {
        return reserveService.insertUserReservation(reserveDto);
    }
}
