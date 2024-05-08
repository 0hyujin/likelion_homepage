package com.homepage.likelion.test.domain;

import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
// @Setter X
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    // 기본키 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
