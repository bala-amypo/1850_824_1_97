package com.example.demo.service.impl;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TemplateServiceImpl {
    private final CertificateTemplateRepository templateRepository;

    public CertificateTemplate addTemplate(CertificateTemplate t) {
        if (templateRepository.findByTemplateName(t.getTemplateName()).isPresent())
            throw new RuntimeException("Template name exists");
        return templateRepository.save(t);
    }
}
