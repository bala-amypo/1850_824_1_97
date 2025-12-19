package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime verifiedAt;

    private String status; // SUCCESS / FAILED

    private String ipAddress;

    @ManyToOne
    private Certificate certificate;

   

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return LocalDateTime return the verifiedAt
     */
    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    /**
     * @param verifiedAt the verifiedAt to set
     */
    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    /**
     * @return String return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return Certificate return the certificate
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * @param certificate the certificate to set
     */
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
    
    public VerificationLog(Certificate certificate, Long id, String ipAddress, String status, LocalDateTime verifiedAt) {
        this.certificate = certificate;
        this.id = id;
        this.ipAddress = ipAddress;
        this.status = status;
        this.verifiedAt = verifiedAt;
    }
    public VerificationLog(){}


}
