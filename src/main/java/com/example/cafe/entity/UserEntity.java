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
@Table(name = "user_info")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(length = 20, nullable = false)
    private String user_name;

    @Column(length = 50 , nullable = false)
    private String user_pw;

    @Column(length = 50, nullable = false, unique = true)
    private String user_email;

    @ToString.Exclude
    @Builder.Default//값이 들어왔을 때 기본으로 참조
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST)
    private List<UserReservationEntity> userReservationEntities = new ArrayList<>();
}