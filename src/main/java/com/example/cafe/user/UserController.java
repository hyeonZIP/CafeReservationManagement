package com.example.cafe.user;

import com.example.cafe.dto.CustomUserDetails;
import com.example.cafe.dto.UserDto;
import com.example.cafe.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Secured("ROLE_USER")
    @GetMapping("/info")
    public ResponseEntity<?> userInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails)
    {
        log.info("customUserDetails :" + customUserDetails);

        UserEntity userEntity = customUserDetails.getUserEntity();
        log.info("user : " + userEntity);

        //인증된 사용자 정보
        if(userEntity !=null)
        {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }

        //인증 되지 않음
        return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("")
    public ResponseEntity<?> join(@RequestBody UserDto userDto) throws Exception
    {
        int result = userService.insert(userDto);

        if(result >0)
        {
            log.info("회원가입 성공!");
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else
        {
            log.info("회원가입 실패..");
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_USER")
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody UserDto userDto) throws Exception {
        log.info("[PUT] - /users");
        boolean result = userService.update(userDto);

        if(Boolean.TRUE.equals(result) ) {
            log.info("회원수정 성공! - SUCCESS");
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else {
            log.info("회원수정 실패! - FAIL");
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }
    @Secured("ROLE_USER")          //  USER 권한 설정
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> destroy(@PathVariable("userId") long idx) throws Exception {
        log.info("[DELETE] - /users/{idx}");

        boolean result = userService.delete(idx);

        if(result) {
            log.info("회원삭제 성공! - SUCCESS");
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }
        else {
            log.info("회원삭제 실패! - FAIL");
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }

    }
}