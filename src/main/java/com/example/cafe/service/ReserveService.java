package com.example.cafe.service;

import com.example.cafe.dto.CafeMenuDto;
import com.example.cafe.dto.CafeSectorDto;
import com.example.cafe.dto.ReserveDto;
import com.example.cafe.dto.TableTemplateDto;
import com.example.cafe.entity.*;
import com.example.cafe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final CafeSectorRepository cafeSectorRepository;
    private final CafeMenuRepository cafeMenuRepository;
    private final MenuOrderRepository menuOrderRepository;
    private final UserReservationRepository userReservationRepository;
    private final UserRepository userRepository;
    private final TableTemplateRepository tableTemplateRepository;

    /**
     *  선택한 카페에 해당하는 sector 리스트 가져오고
     *  default로 지정된 값을 통해 바로 findByCafeSectorIdx를 실행하도록 설계
     */
    public List<CafeSectorDto> findByCafeIdx(Long idx)
    {
        return cafeSectorRepository.findByCafeIdx(idx);
    }

    /**
     * Sector를 선택 할 때마다 테이블 컴포넌트를 가져옴
     */
    public List<TableTemplateDto> findByCafeSectorIdx(Long idx)
    {
        return cafeSectorRepository.findByCafeSectorIdx(idx);
    }

    /**
     * 동일하게 선택한 카페 idx에 해당하는 메뉴 리스트를 가져온다
     */
    public List<CafeMenuDto> selectCafeMenu(Long idx)
    {
        return cafeMenuRepository.findByCafeIdx(idx);
    }

    /**
     * 음료 선택까지 완료 시 테이블 선택 정보 기반으로 user_reservation테이블 생성
     */
    public int insertUserReservation(ReserveDto reserveDto)
    {
        UserEntity userEntity = userRepository.findById(reserveDto.getUserIdx()).get();
        TableTemplateEntity tableTemplateEntity = tableTemplateRepository.findById(reserveDto.getTableIdx()).get();

        //유저 예약 테이블에 userId와 TableTemplateId를 저장
        UserReservationEntity userReservationEntity = UserReservationEntity.builder()
                .userEntity(userEntity)
                .req(LocalDateTime.now())
                .res(LocalDateTime.now())
                .tableTemplateEntity(tableTemplateEntity).build();

        //reserveDto에 userId, tabletemplateId를 받아오고나서 메뉴주문으로 넘어감
        //음료 리스트와, 음료 카운트 리스트 2개가 있다
        //메뉴 엔티티에 리스트에 담긴 값을 하나하나 빼서 등록을 해준다. 카운트도 동일
        for(int i=0; i<reserveDto.getMenus().size(); i++)
        {
            System.out.println("반복 실행 카운트 : i >> " + i);
            Optional<CafeMenuEntity> cafeMenuEntity = cafeMenuRepository.findById(reserveDto.getMenus().get(i));
            userReservationEntity.addOrderMenu(MenuOrderEntity.builder()
                            .cafeMenuEntity(cafeMenuEntity.get())
                            .count(reserveDto.getCount().get(i))
                            .userReservationEntity(userReservationEntity).build());
        }
        try
        {
            userReservationRepository.save(userReservationEntity);
            tableTemplateEntity.setUsing(true);
            tableTemplateRepository.save(tableTemplateEntity);
            return 1;
        }catch (Exception e)
        {
            System.out.println("에러 : " + e);
            return 0;
        }
    }
}
