package com.CinemaApp.service;

import com.CinemaApp.dto.request.LoginRequest;
import com.CinemaApp.dto.request.UserRequest;
import com.CinemaApp.dto.response.LoginResponse;
import com.CinemaApp.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest request);
    LoginResponse loginUser(LoginRequest request);

    void deleteUser(int id);
    List<UserResponse> allUsers();
}
