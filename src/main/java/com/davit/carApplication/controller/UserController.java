package com.davit.carApplication.controller;

import com.davit.carApplication.facade.UserFacade;
import com.davit.carApplication.model.dto.UserDTO;
import com.davit.carApplication.model.param.UserParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserDTO> registration(
            @RequestBody UserParam userParam
    ){
        return ResponseEntity.ok(userFacade.registration(userParam));
    }

    @GetMapping
    public ResponseEntity<UserDTO> getCurrentUser(
            Principal principal
    ){
        return ResponseEntity.ok(userFacade.getCurrentUser(principal.getName()));
    }

}
