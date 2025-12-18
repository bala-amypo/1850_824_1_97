package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CertificateTemplate;

public interface TemplateService {

    // Throw exception if template name already exists
    CertificateTemplate addTemplate(CertificateTemplate template);

    List<CertificateTemplate> getAllTemplates();

    CertificateTemplate findById(Long id);
}
