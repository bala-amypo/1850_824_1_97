package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Certificate;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.service.CertificateService;

import java.time.LocalDate;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {
        Certificate certificate = new Certificate();
        certificate.setIssuedDate(LocalDate.now());
        certificate.setVerificationCode("VER-" + System.currentTimeMillis());
        // Set student and template associations here
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate getCertificate(Long certificateId) {
        return certificateRepository.findById(certificateId).orElse(null);
    }

    @Override
    public Certificate getCertificateByCode(String verificationCode) {
        return certificateRepository.findByVerificationCode(verificationCode).orElse(null);
    }
}
