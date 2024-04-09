package com.example.cafe.service;

import com.example.cafe.entity.CafeEntity;
import com.example.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final CafeRepository cafeRepository;

    public List<String> findTop3By()
    {
        return cafeRepository.findTop3By().stream().map(CafeEntity::getName).toList();
    }
}
