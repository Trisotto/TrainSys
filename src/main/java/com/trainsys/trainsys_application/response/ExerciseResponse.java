package com.trainsys.trainsys_application.response;

public class ExerciseResponse {
    private Long id;
    private String description;

    public ExerciseResponse(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
