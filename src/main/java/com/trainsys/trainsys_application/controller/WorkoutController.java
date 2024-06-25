package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.dto.RegisterWorkoutDto;
import com.trainsys.trainsys_application.entity.WorkoutEntity;
import com.trainsys.trainsys_application.response.WorkoutResponse;
import com.trainsys.trainsys_application.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    @Autowired
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registerWorkout(@Valid @RequestBody RegisterWorkoutDto request) {
        WorkoutResponse createdWorkout = workoutService.registerWorkout(request);
        return new ResponseEntity<>(createdWorkout, HttpStatus.CREATED);
    }
}
