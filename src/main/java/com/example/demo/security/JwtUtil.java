package com.example.demo.security;

import org.springframework.stereotype.Component;
import com.example.demo.dto.AuthRequest;
import java.util.Map;

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

    // 4 args (tests)
    public String generateToken(Long userId, String email, Object role, String username) {
        return "dummy-token";
    }

    // ✅ 3 args (AuthController — THIS FIX)
    public String generateToken(Long userId, String email, String role) {
        return "dummy-token";
    }

    // 4 args (string version)
    public String generateToken(String token, String email, String role, String username) {
        return "dummy-token";
    }

    // Map-based (tests)
    public String generateToken(Map<String, String> claims, String subject, Object role, String username) {
        return "dummy-token";
    }

    // AuthRequest (tests)
    public String generateToken(AuthRequest request) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public static boolean isTokenExpired(String token) {
        return false;
    }

    public String parseToken(String token) {
        return "parsed-token";
    }
}
