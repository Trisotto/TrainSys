package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
