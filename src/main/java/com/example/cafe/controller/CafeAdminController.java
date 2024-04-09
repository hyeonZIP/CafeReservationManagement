package com.example.cafe.controller;

import com.example.cafe.dto.CafeAdminDto;
import com.example.cafe.entity.CafeAdminEntity;
import com.example.cafe.service.CafeAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class CafeAdminController {

    private final CafeAdminService cafeAdminService;

    @PostMapping(value = "/emailduple")
    public boolean emailDupleCheck(@RequestBody CafeAdminDto cafeAdminDto) {
        return cafeAdminService.emailDupleCheck(cafeAdminDto);
    }

    @PostMapping(value = "/signup")
    public CafeAdminEntity signUp(@RequestBody CafeAdminDto cafeAdminDto) {
        return cafeAdminService.signUp(cafeAdminDto);
    }

    @PostMapping("/signin")
    public boolean signin(@RequestBody CafeAdminDto cafeAdminDto) {
        //true면 로그인 성공 , false면 실패
        return cafeAdminService.signIn(cafeAdminDto);
    }
}