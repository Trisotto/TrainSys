package com.trainsys.trainsys_application.controller;

import com.trainsys.trainsys_application.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }
}
