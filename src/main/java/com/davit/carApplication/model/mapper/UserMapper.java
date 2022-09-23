package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.MyUser;
import com.davit.carApplication.model.dto.UserDTO;
import com.davit.carApplication.model.enums.UserStatus;
import com.davit.carApplication.model.param.UserParam;

public class UserMapper {

    public static UserDTO toUserDTO(MyUser user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static MyUser fromParam(UserParam userParam) {
        MyUser user = new MyUser();
        user.setUsername(userParam.getUsername());
        user.setUserStatus(UserStatus.ACTIVE);
        user.setName(userParam.getName());
        user.setRole("user");
        return user;
    }
}
