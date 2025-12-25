package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String verificationCode;
    private String status;
    private String ipAddress;
    private LocalDateTime createdAt;

    public VerificationLog() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
