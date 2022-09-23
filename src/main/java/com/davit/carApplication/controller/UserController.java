package com.davit.carApplication.controller;

import com.davit.carApplication.facade.UserFacade;
import com.davit.carApplication.model.dto.UserDTO;
import com.davit.carApplication.model.param.UserParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    @Operation(summary = "Create user")
    public ResponseEntity<UserDTO> registration(
            @RequestBody UserParam userParam
    ){
        return ResponseEntity.ok(userFacade.registration(userParam));
    }

    @GetMapping
    @Operation(summary = "Get user")
    public ResponseEntity<UserDTO> getCurrentUser(
            Principal principal
    ){
        return ResponseEntity.ok(userFacade.getCurrentUser(principal.getName()));
    }


}
