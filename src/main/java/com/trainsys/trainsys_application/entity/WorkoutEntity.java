package com.trainsys.trainsys_application.entity;

import com.trainsys.trainsys_application.config.database.DatabaseSchema;
import jakarta.persistence.*;

@Entity
@Table(name = "workouts", schema = DatabaseSchema.DEV)
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseEntity exercise;

    @Column(name = "repetitions", nullable = false)
    private int repetitions;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "break_time", nullable = false)
    private int breakTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "day", nullable = false)
    private DayOfWeekEnum day;

    @Column(name = "observations", columnDefinition = "TEXT")
    private String observations;

    @Column(name = "time", nullable = false)
    private int time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public ExerciseEntity getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseEntity exercise) {
        this.exercise = exercise;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
