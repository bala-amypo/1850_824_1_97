package com.example.demo.controller;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.impl.TemplateServiceImpl;

import java.util.List;

public class TemplateController {
    private final TemplateServiceImpl templateService;
    public TemplateController(TemplateServiceImpl templateService) { this.templateService = templateService; }
    public CertificateTemplate add(CertificateTemplate t) { return templateService.addTemplate(t); }
    public List<CertificateTemplate> list() { return null; }
}
