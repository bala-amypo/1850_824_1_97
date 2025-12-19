package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.TemplateService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

    private final CertificateTemplateRepository repo;

    public TemplateServiceImpl(CertificateTemplateRepository repo) {
        this.repo = repo;
    }

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        repo.findByName(template.getName())
                .ifPresent(t -> {
                    throw new IllegalArgumentException("Template name exists");
                });
        return repo.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return repo.findAll();
    }

    @Override
    public CertificateTemplate findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));
    }
}
