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

import java.util.List;
import java.util.stream.Collectors;

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
        return new ExerciseResponse(savedExercise.getId(), savedExercise.getDescription());
    }

    public List<ExerciseResponse> getExercises(UserEntity user) {
        List<ExerciseEntity> exercises = exerciseRepository.findByUserOrderByDescription(user);
        return exercises.stream()
                .map(exercise -> new ExerciseResponse(exercise.getId(),exercise.getDescription()))
                .collect(Collectors.toList());
    }
}
