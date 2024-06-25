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

import java.util.List;
import java.util.stream.Collectors;

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

        return mapToResponse(savedStudent);
    }

    public List<StudentResponse> listStudents(UserEntity user, String search) {
        List<StudentEntity> students;
        if (search == null || search.isEmpty()) {
            students = studentRepository.findByUserOrderByName(user);
        } else {
            students = studentRepository.findByUserAndNameOrCpfOrEmailOrderByName(
                    user, search, search, search);
        }
        return students.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private StudentResponse mapToResponse(StudentEntity student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setDateBirth(student.getDateBirth());
        response.setCpf(student.getCpf());
        response.setContact(student.getContact());
        response.setCep(student.getCep());
        response.setStreet(student.getStreet());
        response.setState(student.getState());
        response.setNeighborhood(student.getNeighborhood());
        response.setCity(student.getCity());
        response.setNumber(student.getNumber());
        return response;
    }
}
