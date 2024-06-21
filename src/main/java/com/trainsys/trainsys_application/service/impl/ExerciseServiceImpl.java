package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.repository.ExerciseRepository;
import com.trainsys.trainsys_application.service.ExerciseService;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
}
