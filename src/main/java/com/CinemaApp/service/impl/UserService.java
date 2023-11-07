package com.CinemaApp.service.impl;

import com.CinemaApp.dto.request.LoginRequest;
import com.CinemaApp.dto.request.UserRequest;
import com.CinemaApp.dto.response.LoginResponse;
import com.CinemaApp.dto.response.UserResponse;
import com.CinemaApp.exception.NotFoundException;
import com.CinemaApp.mapper.UserMapper;
import com.CinemaApp.repository.UserRepository;
import com.CinemaApp.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements com.CinemaApp.service.UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponse saveUser(UserRequest request) {
        var user = UserMapper.INSTANCE.dtoToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        var savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.entityToDto(savedUser);
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundException("Username not found!"));
        return LoginResponse
                .builder()
                .token(jwtService.generateToken(user)).build();
    }

    @Override
    public void deleteUser(int id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found!"));
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> allUsers() {
        var allByStatus = userRepository.findAllByStatus(true);
        return UserMapper.INSTANCE.entityListToDtoList(allByStatus);
    }
}
