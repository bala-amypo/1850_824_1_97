package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.entity.Student;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.Base64;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class CertificateServiceImpl {
    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final CertificateTemplateRepository templateRepository;

    public Certificate generateCertificate(Long studentId, Long templateId) {
        Student s = studentRepository.findById(studentId).orElseThrow();
        CertificateTemplate t = templateRepository.findById(templateId).orElseThrow();

        Certificate c = new Certificate();
        c.setStudent(s);
        c.setTemplate(t);
        c.setVerificationCode("VC-" + new Random().nextInt(10000));
        c.setQrCodeUrl("data:image/png;base64," + Base64.getEncoder().encodeToString(new byte[]{1,2,3}));

        return certificateRepository.save(c);
    }

    public Certificate getCertificate(Long id) {
        return certificateRepository.findById(id).orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    public Certificate findByVerificationCode(String code) {
        return certificateRepository.findByVerificationCode(code).orElseThrow(() -> new RuntimeException("Certificate not found"));
    }

    public List<Certificate> findByStudentId(Long studentId) {
        Student s = studentRepository.findById(studentId).orElseThrow();
        return certificateRepository.findByStudent(s);
    }
}
