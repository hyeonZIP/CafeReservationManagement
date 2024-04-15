package com.example.cafe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "user_info")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    //스프링 시큐리티에서 관리할 이름과 동일하게 지어줌 실제로는 email 이 들어감
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String realname;

    @Column(nullable = false)
    private String role;

    @ToString.Exclude
    @Builder.Default//값이 들어왔을 때 기본으로 참조
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST)
    private List<AuthEntity> authEntity = new ArrayList<>();

    @ToString.Exclude
    @Builder.Default//값이 들어왔을 때 기본으로 참조
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.PERSIST)
    private List<UserReservationEntity> userReservationEntity = new ArrayList<>();
//    public void addReservation(UserReservationEntity entity) {
//        userReservationEntity.add(entity);
//    }
}
