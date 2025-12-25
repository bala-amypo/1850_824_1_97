package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> userData) {
        String email = userData.get("email");
        String password = userData.get("password");

        User user = userService.getUserByEmail(email);
        Map<String, String> response = new HashMap<>();

        if (user != null && user.getPassword().equals(password)) {
            // Generate token with email and role claims
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", user.getRole());

            String token = jwtUtil.generateToken(claims, user.getEmail());
            response.put("token", token);
        } else {
            response.put("error", "Invalid credentials");
        }

        return response;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Set default role if not provided
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userService.saveUser(user);
    }
}
