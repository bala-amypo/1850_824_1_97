package com.example.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Student;
import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.CertificateService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certRepo;
    private final StudentRepository studentRepo;
    private final CertificateTemplateRepository templateRepo;

    public CertificateServiceImpl(
            CertificateRepository certRepo,
            StudentRepository studentRepo,
            CertificateTemplateRepository templateRepo) {
        this.certRepo = certRepo;
        this.studentRepo = studentRepo;
        this.templateRepo = templateRepo;
    }

    @Override
    public Certificate generateCertificate(Long studentId, Long templateId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        CertificateTemplate template = templateRepo.findById(templateId)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));

        Certificate cert = new Certificate();
        cert.setStudent(student);
        cert.setTemplate(template);
        cert.setVerificationCode(UUID.randomUUID().toString());

        return certRepo.save(cert);
    }

    @Override
    public Certificate getCertificate(Long certificateId) {
        return certRepo.findById(certificateId)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate not found"));
    }

    @Override
    public Certificate findByVerificationCode(String code) {
        return certRepo.findByVerificationCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Certificate not found"));
    }

    @Override
    public List<Certificate> findByStudentId(Long studentId) {
        return certRepo.findByStudentId(studentId);
    }
}
