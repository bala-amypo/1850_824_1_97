package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User findByUsername(String username);

    // ✅ REQUIRED
    User findByEmail(String email);

    // ✅ REQUIRED
    User register(User user);
}
