package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import.java.time.LocalDate;

@Entity
public class Certificate{
    @Id
    private Long id;
    private LocalDate issuedDate;
    private String qrCodeUrl;
    @Column(unique=true)
    private String verificationCode;

}