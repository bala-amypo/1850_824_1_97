package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.EnumType;

import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime verifiedAt;

   

public enum VerificationStatus {
    SUCCESS,
    FAILED
}

    private VerificationStatus status;

    private String ipAddress;

    @ManyToOne
    private Certificate certificate;

    // getters and setters
    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public VerificationLog(Long id, LocalDateTime verifiedAt, VerificationStatus status, String ipAddress,
            Certificate certificate) {
        this.id = id;
        this.verifiedAt = verifiedAt;
        this.status = status;
        this.ipAddress = ipAddress;
        this.certificate = certificate;
    }
    public VerificationLog(){}
    
}
