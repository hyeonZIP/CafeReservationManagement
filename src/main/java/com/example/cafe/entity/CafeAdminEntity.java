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
@Table(name = "cafe_admin")
public class CafeAdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafe_admin_id;

    @Column(length = 20, nullable = false)
    private String cafe_admin_name;

    @Column(length = 50, nullable = false)
    private String cafe_admin_pw;

    @Column(length = 50, nullable = false, unique = true)
    private String cafe_admin_email;

    @OneToMany(mappedBy = "cafeEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @Builder.Default
    private List<CafeEntity> cafeEntities = new ArrayList<>();
}
