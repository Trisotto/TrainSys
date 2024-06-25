package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.RegisterWorkoutDto;
import com.trainsys.trainsys_application.entity.DayOfWeekEnum;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.WorkoutEntity;
import com.trainsys.trainsys_application.exception.ConflictException;
import com.trainsys.trainsys_application.repository.ExerciseRepository;
import com.trainsys.trainsys_application.repository.StudentRepository;
import com.trainsys.trainsys_application.repository.WorkoutRepository;
import com.trainsys.trainsys_application.response.StudentResponse;
import com.trainsys.trainsys_application.response.StudentWorkoutResponse;
import com.trainsys.trainsys_application.response.WorkoutResponse;
import com.trainsys.trainsys_application.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public StudentWorkoutResponse listWorkoutsByStudent(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        List<WorkoutEntity> workouts = workoutRepository.findByStudentOrderByDay(student);
        Map<String, List<WorkoutResponse>> workoutsByDay = new LinkedHashMap<>();

        Arrays.stream(DayOfWeekEnum.values()).forEach(day -> workoutsByDay.put(day.name(), new ArrayList<>()));

        for (WorkoutEntity workout : workouts) {
            WorkoutResponse workoutResponse = new WorkoutResponse(
                    workout.getId(),
                    workout.getStudent().getId(),
                    workout.getExercise().getId(),
                    workout.getRepetitions(),
                    workout.getWeight(),
                    workout.getBreakTime(),
                    workout.getDay(),
                    workout.getObservations(),
                    workout.getTime()
            );
            workoutsByDay.get(workout.getDay().name()).add(workoutResponse);
        }

        return new StudentWorkoutResponse(student.getId(), student.getName(), workoutsByDay);
    }

    private WorkoutResponse mapToResponse(WorkoutEntity workout) {
        return new WorkoutResponse(
                workout.getId(),
                workout.getStudent().getId(),
                workout.getExercise().getId(),
                workout.getRepetitions(),
                workout.getWeight(),
                workout.getBreakTime(),
                workout.getDay(),
                workout.getObservations(),
                workout.getTime()
        );
    }
}
