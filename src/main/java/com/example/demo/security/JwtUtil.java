package com.example.demo.security;

import org.springframework.stereotype.Component;
import com.example.demo.dto.AuthRequest;

@Component
public class JwtUtil {

    private String secret;
    private long expiration;

    public JwtUtil() {
    }

    public JwtUtil(String secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(Long userId, String email, Object role, String username) {
        return "dummy-token";
    }

    public String generateToken(AuthRequest request) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public boolean isTokenExpired(String token) {
        return false;
    }

    public String parseToken(String token) {
        return "parsed-token";
    }
}
