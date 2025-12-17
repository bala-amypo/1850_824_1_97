package com.example.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy=GenerationType.Identity)
    private Long id;
    @column(unique=true)
    private String templateName;

}