package com.example.cafe.controller;

import com.example.cafe.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    private final HomeService homeService;

    @PostMapping("/")
    public List<String> findFirst3Names()
    {
        return homeService.findTop3By();
    }
}
