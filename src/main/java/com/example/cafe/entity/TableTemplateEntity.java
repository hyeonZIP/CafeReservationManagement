package com.example.cafe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "table_template")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long table_template_id;

    @Column(nullable = false)
    private int table_template_seat_count;

    @Column(nullable = false)
    private int table_template_seat_no;

    @Column(nullable = false)
    private int table_template_seat_x;

    @Column(nullable = false)
    private int table_template_seat_y;

    @Column(length = 255, nullable = false)
    private String table_template_description;

    @Builder.Default
    @Column(nullable = false)
    private boolean table_template_is_using = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "table_component_id")
    private TableComponentEntity tableComponentEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafe_sector_id")

    private CafeSectorEntity cafeSectorEntity;
}
