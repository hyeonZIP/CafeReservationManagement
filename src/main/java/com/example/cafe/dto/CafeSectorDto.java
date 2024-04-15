package com.example.cafe.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CafeSectorDto {
    private Long sectorIdx;

    private String sectorName;

    private int sectorSizeX;

    private int sectorSizeY;
}
