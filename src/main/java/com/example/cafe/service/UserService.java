package com.example.cafe.service;

import com.example.cafe.dto.UserDto;
import com.example.cafe.entity.UserEntity;
import com.example.cafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean emailDupleCheck(UserDto userDto)
    {
        return userRepository.findByEmail(userDto.getEmail()).isPresent();
    }

    public UserEntity signUp(UserDto userDto)
    {
        UserEntity userEntity = UserEntity.builder()
                .password(userDto.getPassword())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
        return userRepository.save(userEntity);
    }

    public boolean signIn(UserDto userDto)
    {
        var email = userDto.getEmail();
        var password = userDto.getPassword();
        var signInAuth = userRepository.findByEmailAndPassword(email, password);
        return signInAuth.isPresent();
    }

    public List<UserEntity> findAll()
    {
        return userRepository.findAll();
    }
}