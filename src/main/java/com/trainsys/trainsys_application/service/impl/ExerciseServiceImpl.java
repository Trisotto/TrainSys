package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.RegisterExerciseDto;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.exception.ConflictException;
import com.trainsys.trainsys_application.repository.ExerciseRepository;
import com.trainsys.trainsys_application.response.ExerciseResponse;
import com.trainsys.trainsys_application.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public ExerciseResponse createExercise(UserEntity user, RegisterExerciseDto request) throws IllegalArgumentException, ConflictException {
        if (exerciseRepository.existsByUserAndDescription(user, request.getDescription())) {
            throw new ConflictException("Exercise already registered for this user.");
        }
        ExerciseEntity exercise = new ExerciseEntity();
        exercise.setUser(user);
        exercise.setDescription(request.getDescription());
        ExerciseEntity savedExercise = exerciseRepository.save(exercise);
        return new ExerciseResponse(savedExercise.getDescription());
    }
}
