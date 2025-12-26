package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

import java.util.*;

public interface CertificateRepository
        extends JpaRepository<Certificate, Long> {

    Optional<Certificate> findByVerificationCode(String code);
    List<Certificate> findByStudent(Student student);
}
