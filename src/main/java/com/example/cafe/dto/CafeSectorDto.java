package com.example.cafe.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CafeSectorDto {
    private Long idx;

    private String name;

    private int sizeX;

    private int sizeY;
}
