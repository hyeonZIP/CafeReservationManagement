package com.example.cafe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cafe_sector")
public class CafeSectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    //어느 구역인지
    @Column(length = 20, nullable = false)
    private String name;

    //해당 구역의 x,y사이즈 : 테이블 템플릿에는 빈공간의 정보는 담지 않는다
    @Column(nullable = false)
    private int sizeX;
    @Column(nullable = false)
    private int sizeY;

    //cafe_admin > cafe_info
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_id")
    private CafeEntity cafeEntity;

    @OneToMany(mappedBy = "cafeSectorEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<TableTemplateEntity> tableTemplateEntity = new ArrayList<>();
}
