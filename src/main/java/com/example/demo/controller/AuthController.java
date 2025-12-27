package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.impl.UserServiceImpl;

@RestController
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REQUIRED
    public AuthController() {
    }

    // ✅ REQUIRED BY TEST
    public AuthController(UserServiceImpl userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REQUIRED METHOD
    public ResponseEntity<String> login(AuthRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }
}
