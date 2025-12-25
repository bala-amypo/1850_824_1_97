package com.example.demo.controller;

import com.example.demo.service.impl.VerificationServiceImpl;

public class VerificationController {
    private final VerificationServiceImpl verificationService;
    public VerificationController(VerificationServiceImpl verificationService) { this.verificationService = verificationService; }
}
