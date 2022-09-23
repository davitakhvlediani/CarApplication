package com.davit.carApplication.model.domain;

import com.davit.carApplication.model.enums.UserStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String role;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
