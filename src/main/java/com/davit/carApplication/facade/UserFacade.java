package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.MyUser;
import com.davit.carApplication.model.dto.UserDTO;
import com.davit.carApplication.model.mapper.UserMapper;
import com.davit.carApplication.model.param.UserParam;
import com.davit.carApplication.model.param.UserRoleParam;
import com.davit.carApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserDTO registration(UserParam userParam) {
        MyUser myUser = UserMapper.fromParam(userParam);
        if(userParam.getPassword() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required");
        }
        myUser.setPassword(encoder.encode(userParam.getPassword()));
        return UserMapper.toUserDTO(userService.create(myUser));
    }

    public UserDTO getCurrentUser(String name) {
        return UserMapper.toUserDTO(userService.getUserByUsername(name));
    }

    public UserDTO update(UserParam userParam) {
        MyUser myUser = UserMapper.fromParam(userParam);
        if(userParam.getPassword() != null){
            myUser.setPassword(encoder.encode(userParam.getPassword()));
        }

        return UserMapper.toUserDTO(userService.update(myUser.getId(), myUser));
    }

    public UserDTO updateRole(Long id, UserRoleParam userRoleParam) {
        MyUser myUser = userService.get(id);
        myUser.setRole(userRoleParam.getUserRole());
        return UserMapper.toUserDTO(userService.update(id, myUser));
    }

    public UserDTO getUser(Long id) {
        return UserMapper.toUserDTO(userService.get(id));
    }
}
