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
@Table(name = "cafe_info")
public class CafeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String address;

    //cafe_info < user_reservation
    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<UserReservationEntity> userReservationEntity = new ArrayList<>();

    //cafe_info < cafe_menu
    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<CafeMenuEntity> cafeMenuEntity = new ArrayList<>();

    //cafe_info < cafe_floor
    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<CafeSectorEntity> cafeSectorEntity = new ArrayList<>();

    @ToString.Exclude
    @Builder.Default//값이 들어왔을 때 기본으로 참조
    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    private List<AuthEntity> authEntity = new ArrayList<>();
}

