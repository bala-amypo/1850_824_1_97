package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<?> register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();

        return ResponseEntity.ok(userService.register(user));
    }

    public ResponseEntity<?> login(AuthRequest request) {
        try {
            User user = userService.findByEmail(request.getEmail());
            String token = jwtUtil.generateToken(
                    Map.of("email", user.getEmail(), "role", user.getRole()),
                    user.getEmail());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
}
