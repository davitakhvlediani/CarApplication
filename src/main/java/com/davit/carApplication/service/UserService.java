package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.MyUser;
import com.davit.carApplication.repostories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyUser getUserByUsername(String username){
        Optional<MyUser> userByUsername = userRepository.findUserByUsername(username);
      return  userByUsername.orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        });
    }

    public MyUser saveUser(MyUser user){
        return userRepository.save(user);
    }

}
