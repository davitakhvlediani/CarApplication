package com.davit.carApplication.model.param;

import com.davit.carApplication.model.enums.UserRole;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRoleParam {

    @NotNull
    private UserRole userRole;
}
