package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.RegisterStudentDto;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse registerStudent(UserEntity user, RegisterStudentDto request);

    List<StudentResponse> listStudents(UserEntity user, String search);

    void deleteStudent(UserEntity user, Long id);
}
