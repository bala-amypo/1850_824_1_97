package com.example.demo.entity;

import jakarta.persistence.Id;

@Id
public class User{
    private Long id;
    private String name;
    @column(unique=true)
    private String email;
    private String role;
}