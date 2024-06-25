package com.trainsys.trainsys_application.response;

public class DashboardResponse {
    private Integer registeredStudents;
    private Integer registeredExercises;
    private String currentUserPlan;
    private Integer remainingStudents;

    public Integer getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Integer registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public Integer getRegisteredExercises() {
        return registeredExercises;
    }

    public void setRegisteredExercises(Integer registeredExercises) {
        this.registeredExercises = registeredExercises;
    }

    public String getCurrentUserPlan() {
        return currentUserPlan;
    }

    public void setCurrentUserPlan(String currentUserPlan) {
        this.currentUserPlan = currentUserPlan;
    }

    public Integer getRemainingStudents() {
        return remainingStudents;
    }

    public void setRemainingStudents(Integer remainingStudents) {
        this.remainingStudents = remainingStudents;
    }
}
