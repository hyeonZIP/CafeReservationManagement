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
@Table(name = "cafe_menu")
public class CafeMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafe_menu_id;

    @Column(length = 20, nullable = false)
    private String cafe_menu_name;

    @Column(nullable = false)
    private int cafe_menu_price;

    @Column(length = 20, nullable = false)
    private String cafe_menu_tag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_id")
    private CafeEntity cafeEntity;
}
