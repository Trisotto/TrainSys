package com.trainsys.trainsys_application.service;

import com.trainsys.trainsys_application.dto.RegisterStudentDto;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.response.StudentResponse;

public interface StudentService {
    StudentResponse registerStudent(UserEntity user, RegisterStudentDto request);
}
