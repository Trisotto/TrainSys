package com.trainsys.trainsys_application.repository;

import com.trainsys.trainsys_application.entity.DayOfWeekEnum;
import com.trainsys.trainsys_application.entity.ExerciseEntity;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {
    boolean existsByExercise(ExerciseEntity exercise);

    boolean existsByStudentAndExerciseAndDay(StudentEntity student, ExerciseEntity exercise, DayOfWeekEnum day);

    List<WorkoutEntity> findByStudentOrderByDay(StudentEntity student);
}
