package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.repository.ExerciseRepository;
import com.trainsys.trainsys_application.repository.StudentRepository;
import com.trainsys.trainsys_application.repository.UserRepository;
import com.trainsys.trainsys_application.response.DashboardResponse;
import com.trainsys.trainsys_application.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public DashboardResponse getDashboardData(UserEntity user) {
        DashboardResponse dashboardResponse = new DashboardResponse();
        Integer registeredStudents = studentRepository.countByUser(user);
        Integer registeredExercises = exerciseRepository.countByUser(user);
        String currentUserPlan = user.getPlan().getName();
        Integer remainingStudents = user.getPlan().getStudentsLimit() - registeredStudents;

        dashboardResponse.setRegisteredStudents(registeredStudents);
        dashboardResponse.setRegisteredExercises(registeredExercises);
        dashboardResponse.setCurrentUserPlan(currentUserPlan);
        dashboardResponse.setRemainingStudents(remainingStudents);

        return dashboardResponse;
    }
}
