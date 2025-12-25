package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public Student add(Student student) {
        return service.addStudent(student);
    }

    public List<Student> list() {
        return service.getAllStudents();
    }
}
