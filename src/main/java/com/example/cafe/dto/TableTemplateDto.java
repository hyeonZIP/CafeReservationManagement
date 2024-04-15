package com.example.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableTemplateDto {
    private Long tableTemplateId;
    private Integer seatCount;
    private Integer seatNo;
    private Integer tableTemplateX;
    private Integer tableTemplateY;
    private String tableDescription;
    private Boolean isUsing;
    private Integer componentId;
    private String componentName;
}
