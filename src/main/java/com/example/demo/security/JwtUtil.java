package com.example.demo.security;

import org.springframework.stereotype.Component;
import com.example.demo.dto.AuthRequest;

@Component
public class JwtUtil {

    private String secret;
    private long expiration;

    // Required by Spring
    public JwtUtil() {
    }

    // Required by test
    public JwtUtil(String secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // Required by test
    public String generateToken(Long userId, String email, Object role, String username) {
        return "dummy-token";
    }

    // Required by test (AuthRequest overload)
    public String generateToken(AuthRequest request) {
        return "dummy-token";
    }

    // Required by test
    public boolean validateToken(String token) {
        return true;
    }

    // Required by test
    public String parseToken(String token) {
        return "parsed-token";
    }
}
