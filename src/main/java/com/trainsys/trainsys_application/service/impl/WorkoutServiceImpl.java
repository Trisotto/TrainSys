package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.repository.WorkoutRepository;
import com.trainsys.trainsys_application.service.WorkoutService;
import org.springframework.stereotype.Service;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }
}
