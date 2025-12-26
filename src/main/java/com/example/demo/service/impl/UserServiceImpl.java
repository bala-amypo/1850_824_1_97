package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl {

    private UserRepository userRepository;

    // REQUIRED by tests
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Default constructor (Spring)
    public UserServiceImpl() {
    }

    public User register(User user) {
        return user;
    }

    public User findByEmail(String email) {
        return new User();
    }
}
