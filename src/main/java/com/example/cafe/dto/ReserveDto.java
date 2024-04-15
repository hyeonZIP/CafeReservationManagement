package com.example.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDto {
    private Long userIdx;//유저 아이디
    private LocalDateTime req;
    private LocalDateTime res;
    private Long tableIdx;//테이블의 아이디

    @Builder.Default
    private List<Long> menus = new ArrayList<>();

    private List<Integer> count = new ArrayList<>();
    public void setMenuIdx(Long idx)
    {
        menus.add(idx);
    }
}
