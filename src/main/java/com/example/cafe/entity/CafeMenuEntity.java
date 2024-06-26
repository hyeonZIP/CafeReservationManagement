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
@Table(name = "cafe_menu")
public class CafeMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(length = 20, nullable = false)
    private String tag;

    //cafe_menu > cafe_info
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_id")
    private CafeEntity cafeEntity;

    @ToString.Exclude
    @Builder.Default//값이 들어왔을 때 기본으로 참조
    @OneToMany(mappedBy = "cafeMenuEntity", cascade = CascadeType.PERSIST)
    private List<MenuOrderEntity> menuOrderEntity = new ArrayList<>();
}
