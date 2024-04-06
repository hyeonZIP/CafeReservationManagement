package com.example.cafe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cafe_floor")
public class CafeFloorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafe_floor_id;

    @Column(length = 50, nullable = false)
    private String cafe_floor_num;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_admin_id")
    private CafeAdminEntity cafeAdminEntity;
}
