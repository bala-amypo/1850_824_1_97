package com.example.demo.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {}

