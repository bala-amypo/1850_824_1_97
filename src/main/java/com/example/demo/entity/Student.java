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
    private String name;
    @column(unique=true)
    private String email;
    private String rollNumber;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(string name){
        this.name=name;
    }
    


}