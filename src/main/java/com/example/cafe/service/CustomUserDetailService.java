package com.example.cafe.service;

import com.example.cafe.dto.CustomUserDetails;
import com.example.cafe.entity.UserEntity;
import com.example.cafe.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {
    //UserDetailService는 시큐리티 코어

    private final UserRepository userRepository;

    //optional 생성자? xx
    public CustomUserDetailService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity != null)
        {
            return new CustomUserDetails(userEntity);
        }

//        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
//        if (userEntity.isPresent())
//        {
//            return new CustomUserDetails(userEntity.get());
//        }
        return null;
    }
}
