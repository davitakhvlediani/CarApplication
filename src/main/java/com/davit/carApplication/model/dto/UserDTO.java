package com.davit.carApplication.model.dto;

import com.davit.carApplication.model.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String username;

    private String name;

    private UserRole role;
}
