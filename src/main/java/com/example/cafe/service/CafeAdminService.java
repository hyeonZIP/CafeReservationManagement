package com.example.cafe.service;

import com.example.cafe.dto.CafeAdminDto;
import com.example.cafe.entity.CafeAdminEntity;
import com.example.cafe.repository.CafeAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeAdminService {
    private final CafeAdminRepository cafeAdminRepository;

    public boolean emailDupleCheck(CafeAdminDto cafeAdminDto)
    {
        return cafeAdminRepository.findByEmail(cafeAdminDto.getEmail()).isPresent();
    }
    public CafeAdminEntity signUp(CafeAdminDto cafeAdminDto)
    {
        CafeAdminEntity cafeAdminEntity = CafeAdminEntity.builder()
                .password(cafeAdminDto.getPassword())
                .name(cafeAdminDto.getName())
                .email(cafeAdminDto.getEmail())
                .build();
        return cafeAdminRepository.save(cafeAdminEntity);
    }

    public boolean signIn(CafeAdminDto cafeAdminDto)
    {
        var email = cafeAdminDto.getEmail();
        var password = cafeAdminDto.getPassword();
        var signInAuth = cafeAdminRepository.findByEmailAndPassword(email, password);
        return signInAuth.isPresent();
    }
}