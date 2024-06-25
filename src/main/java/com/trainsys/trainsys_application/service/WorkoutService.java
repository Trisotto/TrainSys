package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.RegisterWorkoutDto;
import com.trainsys.trainsys_application.entity.WorkoutEntity;
import com.trainsys.trainsys_application.response.StudentWorkoutResponse;
import com.trainsys.trainsys_application.response.WorkoutResponse;

import java.util.List;

public interface WorkoutService {
    WorkoutResponse registerWorkout(RegisterWorkoutDto request);

    StudentWorkoutResponse listWorkoutsByStudent(Long id);
}
