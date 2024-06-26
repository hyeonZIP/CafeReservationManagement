package com.example.cafe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "table_template")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Builder.Default
    @Column(nullable = true)
    private int seatCount = 0;

    @Column(nullable = false)
    private int seatNo;

    @Column(nullable = false)
    private int seatX;

    @Column(nullable = false)
    private int seatY;

    @Column(nullable = false)
    private String description;

    @Builder.Default
    @Column(nullable = false)
    private boolean isUsing = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "table_component_id")
    private TableComponentEntity tableComponentEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_sector_id")
    private CafeSectorEntity cafeSectorEntity;

    @ToString.Exclude
    @Builder.Default//값이 들어왔을 때 기본으로 참조
    @OneToMany(mappedBy = "tableTemplateEntity", cascade = CascadeType.PERSIST)
    private List<UserReservationEntity> userReservationEntity = new ArrayList<>();
}
