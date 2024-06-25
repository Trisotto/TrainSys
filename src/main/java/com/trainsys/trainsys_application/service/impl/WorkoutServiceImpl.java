package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.RegisterWorkoutDto;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.WorkoutEntity;
import com.trainsys.trainsys_application.exception.ConflictException;
import com.trainsys.trainsys_application.repository.ExerciseRepository;
import com.trainsys.trainsys_application.repository.StudentRepository;
import com.trainsys.trainsys_application.repository.WorkoutRepository;
import com.trainsys.trainsys_application.response.StudentResponse;
import com.trainsys.trainsys_application.response.WorkoutResponse;
import com.trainsys.trainsys_application.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    @Autowired
    private final WorkoutRepository workoutRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public WorkoutResponse registerWorkout(RegisterWorkoutDto request) throws ConflictException {
        StudentEntity student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        ExerciseEntity exercise = exerciseRepository.findById(request.getExerciseId())
                .orElseThrow(() -> new IllegalArgumentException("Exercise not found"));

        if (workoutRepository.existsByStudentAndExerciseAndDay(student, exercise, request.getDay())) {
            throw new ConflictException("Exercise already registered for this day");
        }

        WorkoutEntity workout = new WorkoutEntity();
        workout.setStudent(student);
        workout.setExercise(exercise);
        workout.setRepetitions(request.getRepetitions());
        workout.setWeight(request.getWeight());
        workout.setBreakTime(request.getBreakTime());
        workout.setDay(request.getDay());
        workout.setObservations(request.getObservations());
        workout.setTime(request.getTime());

        WorkoutEntity savedWorkout = workoutRepository.save(workout);

        return mapToResponse(savedWorkout);
    }

    private WorkoutResponse mapToResponse(WorkoutEntity workout) {
        WorkoutResponse response = new WorkoutResponse();
        response.setId(workout.getId());
        response.setStudentId(workout.getStudent().getId());
        response.setExerciseId(workout.getExercise().getId());
        response.setRepetitions(workout.getRepetitions());
        response.setWeight(workout.getWeight());
        response.setBreakTime(workout.getBreakTime());
        response.setDay(workout.getDay());
        response.setObservations(workout.getObservations());
        response.setTime(workout.getTime());
        return response;
    }
}
