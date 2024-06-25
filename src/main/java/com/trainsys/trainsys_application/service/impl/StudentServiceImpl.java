package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.RegisterStudentDto;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.exception.ForbiddenException;
import com.trainsys.trainsys_application.repository.StudentRepository;
import com.trainsys.trainsys_application.repository.UserRepository;
import com.trainsys.trainsys_application.response.StudentResponse;
import com.trainsys.trainsys_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse registerStudent(UserEntity user, RegisterStudentDto request) throws ForbiddenException {
        int currentStudents = studentRepository.countByUser(user);
        int maxStudents = user.getPlan().getStudentsLimit();

        if (currentStudents >= maxStudents) {
            throw new ForbiddenException("Plan's registration limit reached");
        }

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        if (studentRepository.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("CPF already exists");
        }

        StudentEntity student = new StudentEntity();
        student.setUser(user);
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setDateBirth(request.getDateBirth());
        student.setCpf(request.getCpf());
        student.setContact(request.getContact());
        student.setCep(request.getCep());
        student.setStreet(request.getStreet());
        student.setState(request.getState());
        student.setNeighborhood(request.getNeighborhood());
        student.setCity(request.getCity());
        student.setNumber(request.getNumber());

        StudentEntity savedStudent = studentRepository.save(student);

        StudentResponse response = new StudentResponse();
        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());
        response.setDateBirth(savedStudent.getDateBirth());
        response.setCpf(savedStudent.getCpf());
        response.setContact(savedStudent.getContact());
        response.setCep(savedStudent.getCep());
        response.setStreet(savedStudent.getStreet());
        response.setState(savedStudent.getState());
        response.setNeighborhood(savedStudent.getNeighborhood());
        response.setCity(savedStudent.getCity());
        response.setNumber(savedStudent.getNumber());

        return response;
    }
}
