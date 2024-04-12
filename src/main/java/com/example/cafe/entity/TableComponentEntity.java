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
@Table(name = "table_component")
public class TableComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(length = 20, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "tableComponentEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<TableTemplateEntity> tableTemplateEntity = new ArrayList<>();
}
