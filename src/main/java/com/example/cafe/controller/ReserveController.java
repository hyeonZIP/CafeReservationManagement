package com.example.cafe.controller;

import com.example.cafe.dto.*;
import com.example.cafe.service.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_USER")
    @GetMapping("/sector")
    public List<CafeSectorDto> test(@RequestParam(name = "idx") Long idx)
    {
        return reserveService.findByCafeIdx(idx);
    }

    @Secured("ROLE_USER")
    @GetMapping("/table")
    public List<TableTemplateDto> test2(@RequestParam(name="idx") Long idx)
    {
        return reserveService.findByCafeSectorIdx(idx);
    }

    @Secured("ROLE_USER")
    @GetMapping("/cafe-menu")
    public List<CafeMenuDto> test3(@RequestParam(name = "idx") Long idx)
    {
        return reserveService.selectCafeMenu(idx);
    }


    //insert-reservation이 갑자기 안되면 여기서 / 지우기
    @Secured("ROLE_USER")
    @PostMapping("/insert-reservation")
    public int insertUserReservation(@RequestBody ReserveDto reserveDto)
    {
        System.out.println("컨트롤러 동작");
        return reserveService.insertUserReservation(reserveDto);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/cancel/{reservationIdx}")
    public int cancel(@PathVariable("reservationIdx") long idx)
    {
        boolean result = reserveService.cancel(idx);

        if(result)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
