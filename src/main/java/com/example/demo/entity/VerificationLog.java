package com.example.demo.entity;


import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime verifiedAt;

    @Enumerated(EnumType.STRING)
    private VerificationStatus status;

    private String ipAddress;

    @ManyToOne
    private Certificate certificate;

    // ✅ REQUIRED getters & setters
    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }

    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
