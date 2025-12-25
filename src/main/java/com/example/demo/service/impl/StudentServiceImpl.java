package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(Student s) {
        if (studentRepository.findByEmail(s.getEmail()).isPresent())
            throw new RuntimeException("Student email exists");
        if (studentRepository.findByRollNumber(s.getRollNumber()).isPresent())
            throw new RuntimeException("Student roll number exists");
        return studentRepository.save(s);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
