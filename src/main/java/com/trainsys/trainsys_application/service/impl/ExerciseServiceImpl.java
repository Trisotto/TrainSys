package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.RegisterExerciseDto;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.exception.ConflictException;
import com.trainsys.trainsys_application.exception.ForbiddenException;
import com.trainsys.trainsys_application.exception.NotFoundException;
import com.trainsys.trainsys_application.repository.ExerciseRepository;
import com.trainsys.trainsys_application.repository.WorkoutRepository;
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

    @Autowired
    private WorkoutRepository workoutRepository;

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

    public void deleteExercise(UserEntity user, Long exerciseId) throws ConflictException, ForbiddenException, NotFoundException {
        ExerciseEntity exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NotFoundException("Exercise not found"));

        if (!exercise.getUser().getId().equals(user.getId())) {
            throw new ForbiddenException("You do not have permission to delete this exercise");
        }

        if (workoutRepository.existsByExercise(exercise)) {
            throw new ConflictException("Exercise cannot be deleted due to linked workouts");
        }

        exerciseRepository.delete(exercise);
    }
}
