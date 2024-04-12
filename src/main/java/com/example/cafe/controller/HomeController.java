package com.example.cafe.controller;

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
@RequestMapping("/test")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/cafe")
    public List<?> findByCafeIdx(@RequestParam(name = "idx") Long idx)
    {
        log.info("idx={}", idx);
        return homeService.findByCafeIdx(idx);
    }
}
