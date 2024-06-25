package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.dto.RegisterStudentDto;
import com.trainsys.trainsys_application.dto.UpdateStudentDto;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.StudentResponse;
import com.trainsys.trainsys_application.response.StudentWorkoutResponse;
import com.trainsys.trainsys_application.response.WorkoutResponse;
import com.trainsys.trainsys_application.service.StudentService;
import com.trainsys.trainsys_application.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;
    @Autowired
    private WorkoutService workoutService;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@AuthenticationPrincipal UserEntity user, @PathVariable Long id) {
        studentService.deleteStudent(user, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@AuthenticationPrincipal UserEntity user, @PathVariable Long id, @Valid @RequestBody UpdateStudentDto request) {
        StudentResponse updatedStudent = studentService.updateStudent(user, id, request);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @GetMapping("/{id}/workouts")
    public ResponseEntity<?> listWorkoutsByStudent(@AuthenticationPrincipal UserEntity user, @PathVariable Long id) {
        StudentWorkoutResponse workouts = workoutService.listWorkoutsByStudent(id);
        return new ResponseEntity<>(workouts, HttpStatus.OK);
    }
}
