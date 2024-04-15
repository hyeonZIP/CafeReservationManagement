package com.example.cafe.dto;

import com.example.cafe.entity.CafeMenuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuOrderDto {

    private ArrayList<Long> menuList;
    private ArrayList<Integer> countList;
    private CafeMenuEntity cafeMenuEntity;
    private Integer count;
}
