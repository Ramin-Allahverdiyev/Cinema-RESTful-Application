package com.CinemaApp.controller;

import com.CinemaApp.dto.request.LoginRequest;
import com.CinemaApp.dto.request.UserRequest;
import com.CinemaApp.dto.response.LoginResponse;
import com.CinemaApp.dto.response.UserResponse;
import com.CinemaApp.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponse saveUser(@RequestBody UserRequest request){
        return userService.saveUser(request);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public List<UserResponse> allUser(){
        return userService.allUsers();
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request){
        return userService.loginUser(request);
    }
}
