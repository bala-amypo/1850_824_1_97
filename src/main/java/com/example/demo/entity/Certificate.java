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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }
    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }
    public String getQrCodeUrl() {
        return qrCodeUrl;
    }


    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
    public Certificate(Long id,String issuedDate,String qrCodeUrl,String verificationCode){
        this.id=id;
        this.issuedDate=issuedDate;
        this.qrCodeUrl=qrCodeUrl;
        this.certificate=certificate;
    }
    public Certificate(){}

}