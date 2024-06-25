package com.trainsys.trainsys_application.response;

import com.trainsys.trainsys_application.entity.DayOfWeekEnum;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.StudentEntity;
import jakarta.persistence.*;

public class WorkoutResponse {
    private Long id;

    private Long studentId;

    private Long exerciseId;

    private Integer repetitions;

    private Double weight;

    private Integer breakTime;

    private DayOfWeekEnum day;

    private String observations;

    private Integer time;

    public WorkoutResponse(Long id, Long studentId, Long exerciseId, Integer repetitions, Double weight, Integer breakTime, DayOfWeekEnum day, String observations, Integer time) {
        this.id = id;
        this.studentId = studentId;
        this.exerciseId = exerciseId;
        this.repetitions = repetitions;
        this.weight = weight;
        this.breakTime = breakTime;
        this.day = day;
        this.observations = observations;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Integer breakTime) {
        this.breakTime = breakTime;
    }

    public DayOfWeekEnum getDay() {
        return day;
    }

    public void setDay(DayOfWeekEnum day) {
        this.day = day;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
