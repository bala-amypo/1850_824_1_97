package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.impl.StudentServiceImpl;

import java.util.List;

public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    public Student add(Student s) { return studentService.addStudent(s); }
    public List<Student> list() { return studentService.getAllStudents(); }
}
