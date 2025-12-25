package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student addStudent(Student student) {
        if (repository.findByEmail(student.getEmail()).isPresent()) {
            throw new RuntimeException("Student email exists");
        }
        if (repository.findByRollNumber(student.getRollNumber()).isPresent()) {
            throw new RuntimeException("Student roll exists");
        }
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
