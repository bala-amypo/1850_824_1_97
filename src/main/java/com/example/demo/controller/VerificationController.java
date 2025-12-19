package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/{verificationCode}")
    public VerificationLog verifyCertificate(@PathVariable String verificationCode, @RequestHeader("X-Forwarded-For") String clientIp) {
        return verificationService.verifyCertificate(verificationCode, clientIp);
    }

    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> getLogs(@PathVariable Long certificateId) {
        return verificationService.getLogsByCertificate(certificateId);
    }
}
