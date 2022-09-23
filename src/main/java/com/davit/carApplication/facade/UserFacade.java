package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.MyUser;
import com.davit.carApplication.model.dto.UserDTO;
import com.davit.carApplication.model.mapper.UserMapper;
import com.davit.carApplication.model.param.UserParam;
import com.davit.carApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserDTO registration(UserParam userParam) {
        MyUser myUser = UserMapper.fromParam(userParam);
        myUser.setPassword(encoder.encode(userParam.getPassword()));
        return UserMapper.toUserDTO(userService.create(myUser));
    }

    public UserDTO getCurrentUser(String name) {
        return UserMapper.toUserDTO(userService.getUserByUsername(name));
    }
}
