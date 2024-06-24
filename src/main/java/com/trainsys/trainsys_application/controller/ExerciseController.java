package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.dto.RegisterExerciseDto;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.exception.ConflictException;
import com.trainsys.trainsys_application.response.ExerciseResponse;
import com.trainsys.trainsys_application.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    @Autowired
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createExercise(@AuthenticationPrincipal UserEntity user, @Valid @RequestBody RegisterExerciseDto request) {
        ExerciseResponse createdExercise = exerciseService.createExercise(user, request);
        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> listExercises(@AuthenticationPrincipal UserEntity user) {
        List<ExerciseResponse> exercises = exerciseService.getExercises(user);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
