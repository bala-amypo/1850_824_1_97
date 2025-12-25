package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

public class TemplateController {

    private final TemplateService service;

    public TemplateController(TemplateService service) {
        this.service = service;
    }

    public CertificateTemplate add(CertificateTemplate template) {
        return service.addTemplate(template);
    }

    public List<CertificateTemplate> list() {
        return service.list();
    }
}
