package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.VerificationLog;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.VerificationLogRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VerificationServiceImpl {
    private final CertificateRepository certificateRepository;
    private final VerificationLogRepository logRepository;

    public boolean verifyCertificate(String code, String ip) {
        Certificate c = certificateRepository.findByVerificationCode(code).orElse(null);
        VerificationLog log = new VerificationLog();
        log.setVerificationCode(code);
        log.setIpAddress(ip);
        log.setStatus(c != null ? "SUCCESS" : "FAIL");
        logRepository.save(log);
        return c != null;
    }
}
