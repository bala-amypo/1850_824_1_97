package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "USER");

        return jwtUtil.generateToken(
                claims,
                request.getEmail(),
                "secret"
        );
    }
}
