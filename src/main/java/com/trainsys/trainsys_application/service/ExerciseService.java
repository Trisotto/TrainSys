package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.RegisterExerciseDto;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.ExerciseResponse;

import java.util.List;

public interface ExerciseService {
    ExerciseResponse createExercise(UserEntity user, RegisterExerciseDto request);

    List<ExerciseResponse> getExercises(UserEntity user);

    void deleteExercise(UserEntity user, Long id);
}
