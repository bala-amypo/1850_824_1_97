package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;

public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<AuthResponse> login(AuthRequest req) {
        var userOpt = userService.findByEmail(req.getEmail());
        if (userOpt.isPresent() && new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().matches(req.getPassword(), userOpt.get().getPassword())) {
            String token = jwtUtil.generateToken(userOpt.get().getEmail());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }

    public User register(RegisterRequest req) {
        return userService.register(User.builder().name(req.getName()).email(req.getEmail()).password(req.getPassword()).role(req.getRole()).build());
    }
}
