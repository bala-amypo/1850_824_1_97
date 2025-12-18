package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Certificate;

public interface CertificateService {

    Certificate generateCertificate(Long studentId, Long templateId);

    // Throw "Certificate not found" if missing
    Certificate getCertificate(Long certificateId);

    Certificate findByVerificationCode(String code);

    List<Certificate> findByStudentId(Long studentId);
}
