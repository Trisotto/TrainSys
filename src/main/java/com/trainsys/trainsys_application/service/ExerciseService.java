package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.RegisterExerciseDto;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.ExerciseResponse;

public interface ExerciseService {
    ExerciseResponse createExercise(UserEntity user, RegisterExerciseDto request);
}
