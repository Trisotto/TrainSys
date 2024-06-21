package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.repository.StudentRepository;
import com.trainsys.trainsys_application.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
