package com.trainsys.trainsys_application.response;

import java.util.List;
import java.util.Map;

public class StudentWorkoutResponse {
    private Long studentId;
    private String studentName;
    private Map<String, List<WorkoutResponse>> workouts;

    public StudentWorkoutResponse(Long studentId, String studentName, Map<String, List<WorkoutResponse>> workouts) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.workouts = workouts;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Map<String, List<WorkoutResponse>> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Map<String, List<WorkoutResponse>> workouts) {
        this.workouts = workouts;
    }
}
