package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class CertificateTemplate{
    @Id
    private Long id;
    @Column(unique=true)
    private String templateName;
    private String backgroundUrl
}