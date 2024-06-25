package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.dto.RegisterStudentDto;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.StudentResponse;
import com.trainsys.trainsys_application.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registerStudent(@AuthenticationPrincipal UserEntity user, @Valid @RequestBody RegisterStudentDto request) {
        StudentResponse registeredStudent = studentService.registerStudent(user, request);
        return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> listStudents(@AuthenticationPrincipal UserEntity user,
                                          @RequestParam(required = false) String search) {
        List<StudentResponse> students = studentService.listStudents(user, search);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
