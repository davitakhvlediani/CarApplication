package com.davit.carApplication.model.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserParam {

    @NotNull
    private String name;

    @NotNull
    private String username;

    @Min(6)
    private String password;
}
