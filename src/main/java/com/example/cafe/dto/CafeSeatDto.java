package com.example.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CafeSeatDto {
    private Long cafeIdx;
    private String cafeName;
    private Long unUsingCount;
    private Long totalCount;
}
