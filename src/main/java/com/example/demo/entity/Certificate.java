package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    private LocalDate issuedDate;

    private String qrCodeUrl;

    @Column(unique = true)
    private String verificationCode;
    
   

    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
    }

   
    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    public CertificateTemplate getTemplate() {
        return template;
    }

   
    public void setTemplate(CertificateTemplate template) {
        this.template = template;
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
    public Certificate(


}
