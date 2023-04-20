package com.example.demo.controller;

import com.example.demo.controller.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {

    @Query("select u from UserVO u where u.userId=:userId and u.password=:password")
    UserVO selectUserInfo(@Param("userId")String userId, @Param("password")String password);

}
