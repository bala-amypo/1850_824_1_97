package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@Entity
public class VerificationLog{
    @Id
    private Long id;
    private LocalDateTime verifiedAt;
    public String Status={
        SUCCESS,
        FAILED
    } 
    private Status status;
    private String ipAddress;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public Status getStatus() {
        return status;
    }

  
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public VerificationLog(Long id,LocalDateTime verifiedAt,Status status,String ipAddress){
        this.id=id;
        this verifiedAt=verifiedAt;
        this.status=status;
        this.ipAddress=
    }
}