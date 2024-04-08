package com.example.cafe.controller;

import com.example.cafe.dto.UserDto;
import com.example.cafe.entity.UserEntity;
import com.example.cafe.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    @PostMapping(value = "/emailduple")
    public boolean emailDupleCheck(@RequestBody UserDto userDto)
    {
        return userService.emailDupleCheck(userDto);
    }

    @PostMapping(value = "/signup")
    public UserEntity signUp(@RequestBody UserDto userDto)
    {
        System.out.println(userDto.getEmail() + " || " + userDto.getPassword() + " || " + userDto.getName());
        return userService.signUp(userDto);
    }

    @PostMapping("/signin")
    public boolean signin(@RequestBody UserDto userDto)
        {
            //true면 로그인 성공 , false면 실패
            return userService.signIn(userDto);
        }

    @GetMapping("/")
    public List<UserDto> findAll()
    {
        List<UserEntity> users = userService.findAll();
        List<UserDto> dtos = new ArrayList<>();
        for (UserEntity user : users) {
            UserDto dto = new UserDto();
            dto.setPassword(user.getPassword());
            dto.setEmail(user.getEmail());
            dto.setName(user.getName());
            dtos.add(dto);
        }
        return dtos;
    }


}