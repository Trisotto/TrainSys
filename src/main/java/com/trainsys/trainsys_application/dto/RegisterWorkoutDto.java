package com.trainsys.trainsys_application.dto;

import com.trainsys.trainsys_application.entity.DayOfWeekEnum;
import jakarta.validation.constraints.NotNull;

public class RegisterWorkoutDto {
    @NotNull(message = "Student ID is mandatory")
    private Long studentId;

    @NotNull(message = "Exercise ID is mandatory")
    private Long exerciseId;

    @NotNull(message = "Repetitions are mandatory")
    private Integer repetitions;

    @NotNull(message = "Weight is mandatory")
    private Double weight;

    @NotNull(message = "Break time is mandatory")
    private Integer breakTime;

    @NotNull(message = "Day is mandatory")
    private DayOfWeekEnum day;

    private String observations;

    @NotNull(message = "Time is mandatory")
    private Integer time;

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
