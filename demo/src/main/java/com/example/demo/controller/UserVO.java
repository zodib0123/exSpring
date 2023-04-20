package com.example.demo.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSn;
    private String userId;
    private String password;
    private String userName;
    private String role;
}
