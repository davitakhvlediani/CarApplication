package com.davit.carApplication.controller;

import com.davit.carApplication.facade.UserFacade;
import com.davit.carApplication.model.dto.UserDTO;
import com.davit.carApplication.model.param.UserParam;
import com.davit.carApplication.model.param.UserRoleParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PutMapping
    @Operation(summary = "Update current user")
    public ResponseEntity<UserDTO> update(
            @RequestBody UserParam userParam
    ){
        return ResponseEntity.ok(userFacade.update(userParam));
    }


    @GetMapping
    @Operation(summary = "Get current user")
    public ResponseEntity<UserDTO> getCurrentUser(
            Principal principal
    ){
        return ResponseEntity.ok(userFacade.getCurrentUser(principal.getName()));
    }

    @PatchMapping("/{id}/role")
    @Operation(summary = "Update user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> update(
            @PathVariable Long id,
            @RequestBody UserRoleParam userRoleParam
    ){
        return ResponseEntity.ok(userFacade.updateRole(id, userRoleParam));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(userFacade.getUser(id));
    }

}
