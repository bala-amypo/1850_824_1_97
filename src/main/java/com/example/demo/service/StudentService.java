package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

    // Throw exception if student email already exists
    Student addStudent(Student student);

    List<Student> getAllStudents();

    // Throw "Student not found" if id is missing
    Student findById(Long id);
}
