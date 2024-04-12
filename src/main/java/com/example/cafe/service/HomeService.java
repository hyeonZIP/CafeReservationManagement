package com.example.cafe.service;

import com.example.cafe.repository.CafeRepository;
import com.example.cafe.repository.UserReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HomeService {

    private final CafeRepository cafeRepository;
    private final UserReservationRepository userReservationRepository;

    public List<?> findByCafeIdx(Long idx)
    {
        return cafeRepository.findByCafeIdx(idx);
    }

//    public List<?> findByUserIdx(Long idx)
//    {
//        return userReservationRepository.findByUserIdx(idx);
//    }

}
