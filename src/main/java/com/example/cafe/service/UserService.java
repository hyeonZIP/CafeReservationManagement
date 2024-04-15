package com.example.cafe.service;

import com.example.cafe.dto.UserDto;
import com.example.cafe.entity.UserEntity;
import com.example.cafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 회원가입 기능
     */
    public int insert(UserDto userDto)
    {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        String realname = userDto.getRealname();

        log.info(username + " + " + password + " + " + realname + " | 위치 : UserService");

        Boolean isExist = userRepository.existsByUsername(username);

        if(isExist)
        {
            //이메일이 중복되면 리턴
            return 0;
        }

        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .realname(realname)
                .role("ROLE_USER")
                .build();

        userRepository.save(userEntity);
        return 1;
    }

    public boolean update(UserDto userDto)
    {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        String realname = userDto.getRealname();

        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity !=null)
        {
            userEntity.setPassword(bCryptPasswordEncoder.encode(password));
            userEntity.setRealname(realname);
            userRepository.save(userEntity);
            log.info("수정 성공");
            return true;
        }
        log.info("수정 실패");
        return false;
//        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

//        userRepository.
    }

    public boolean delete(long idx)
    {
        //deleteById?
        //delete(user)
        Optional<UserEntity> userEntity = userRepository.findById(idx);
        if(userEntity.isPresent())
        {
            userRepository.delete(userEntity.get());
            return true;
        }
        return false;
    }
}