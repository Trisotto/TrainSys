package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.RegisterWorkoutDto;
import com.trainsys.trainsys_application.entity.WorkoutEntity;
import com.trainsys.trainsys_application.response.WorkoutResponse;

public interface WorkoutService {
    WorkoutResponse registerWorkout(RegisterWorkoutDto request);
}
