package com.example.demo.entity;

public class User {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String role;

    public User() {
    }

    public User(Long id, String email, String username, String password, String role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // 🔹 REQUIRED by AuthController
    public String getRole() {
        return role;
    }
}
