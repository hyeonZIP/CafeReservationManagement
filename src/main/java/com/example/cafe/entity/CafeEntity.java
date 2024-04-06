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
    private Long cafe_id;

    @Column(length = 50, nullable = false)
    private String cafe_name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_admin_id")
    private CafeAdminEntity cafeAdminEntity;

    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<UserReservationEntity> userReservationEntities = new ArrayList<>();

    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<CafeMenuEntity> cafeMenuEntities = new ArrayList<>();

    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<CafeFloorEntity> cafeFloorEntities = new ArrayList<>();
}
