package com.example.cafe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_reservation")
public class UserReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private LocalDateTime req;

    @Column(nullable = false)
    private LocalDateTime res;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "table_template_id")
    private TableTemplateEntity tableTemplateEntity;

    @OneToMany(mappedBy = "userReservationEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    private List<MenuOrderEntity> menuOrderEntity = new ArrayList<>();

    public void addOrderMenu(MenuOrderEntity entity)
    {
        menuOrderEntity.add(entity);
    }
}
