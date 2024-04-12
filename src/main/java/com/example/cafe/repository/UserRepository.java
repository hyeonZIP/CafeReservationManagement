package com.example.cafe.repository;

import com.example.cafe.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /*
    이메일 중복 확인
     */
    Boolean existsByUsername(String username);

    /*
    이름을 통해 특정 유저 확인
     */
    UserEntity findByUsername(String username);
    @Modifying
    @Query("delete from UserEntity u where u.idx = :idx")
    int deleteByIDX(@Param("idx") Long idx);

//    Optional<UserEntity> findByUsername(String username);



}
