package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
public class User{
    public enum Role{
        ADMIN,
        STAFF
    }
    @Id
    @generatedValue(strategy=generationType.IDENTITY)
    private Long id;
    private String name;
    @column(unique=true)
    private String email;
    private Role role=Role=STAFF;
    
}