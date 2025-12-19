package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.VerificationLog;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationLogRepository logRepository;
    private final CertificateRepository certificateRepository;

    public VerificationServiceImpl(
            VerificationLogRepository logRepository,
            CertificateRepository certificateRepository) {
        this.logRepository = logRepository;
        this.certificateRepository = certificateRepository;
    }

    @Override
    public VerificationLog verifyCertificate(String verificationCode, String clientIp) {

        Certificate certificate =
                certificateRepository.findByVerificationCode(verificationCode).orElse(null);

        VerificationLog log = new VerificationLog();
        log.setCertificate(certificate);
        log.setVerifiedAt(LocalDateTime.now());
        log.setIpAddress(clientIp);

        // ✅ FIXED ENUM USAGE (NO STRINGS)
        log.setStatus(
                certificate != null
                        ? VerificationLog.VerificationStatus.SUCCESS
                        : VerificationLog.VerificationStatus.FAILED
        );

        return logRepository.save(log);
    }

    @Override
    public List<VerificationLog> getLogsByCertificate(Long certificateId) {
        return logRepository.findByCertificateId(certificateId);
    }
}
