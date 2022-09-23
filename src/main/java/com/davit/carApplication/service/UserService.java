package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.MyUser;
import com.davit.carApplication.repostories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService extends AbstractService<MyUser, UserRepository> {


    public UserService(UserRepository repository) {
        super(repository);
    }

    public MyUser getUserByUsername(String username){
        Optional<MyUser> userByUsername = repository.findUserByUsername(username);
      return  userByUsername.orElseThrow(()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

}
