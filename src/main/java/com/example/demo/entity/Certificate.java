package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String verificationCode;
    private String qrCodeUrl;

    @ManyToOne
    private Student student;

    @ManyToOne
    private CertificateTemplate template;
}
