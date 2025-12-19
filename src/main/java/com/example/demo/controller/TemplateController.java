package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private final TemplateService service;

    public TemplateController(TemplateService service) {
        this.service = service;
    }

    // Add new certificate template
    @PostMapping
    public CertificateTemplate addTemplate(@RequestBody CertificateTemplate template) {
        return service.addTemplate(template);
    }

    // Get all templates
    @GetMapping
    public List<CertificateTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }

    // Get template by ID
    @GetMapping("/{id}")
    public CertificateTemplate getTemplateById(@PathVariable Long id) {
        return service.findById(id);
    }
}
