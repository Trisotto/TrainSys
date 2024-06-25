package com.trainsys.trainsys_application.service.impl;

import com.trainsys.trainsys_application.dto.RegisterStudentDto;
import com.trainsys.trainsys_application.dto.UpdateStudentDto;
import com.trainsys.trainsys_application.dto.AddressDto;
import com.trainsys.trainsys_application.entity.StudentEntity;
import com.trainsys.trainsys_application.entity.UserEntity;
import com.trainsys.trainsys_application.exception.ForbiddenException;
import com.trainsys.trainsys_application.exception.NotFoundException;
import com.trainsys.trainsys_application.repository.StudentRepository;
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
        student.setIsDeleted(false);

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

    public void deleteStudent(UserEntity user, Long studentId) throws ForbiddenException, NotFoundException {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        if (!student.getUser().getId().equals(user.getId())) {
            throw new ForbiddenException("You do not have permission to delete this student");
        }

        student.setIsDeleted(true);
        studentRepository.save(student);
    }

    public StudentResponse updateStudent(UserEntity user, Long studentId, UpdateStudentDto request) throws ForbiddenException, NotFoundException {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found"));

        if (!student.getUser().getId().equals(user.getId())) {
            throw new ForbiddenException("You do not have permission to update this student");
        }

        if (request.getName() != null) student.setName(request.getName());
        if (request.getEmail() != null) student.setEmail(request.getEmail());
        if (request.getDateBirth() != null) student.setDateBirth(request.getDateBirth());
        if (request.getCpf() != null) student.setCpf(request.getCpf());
        if (request.getContact() != null) student.setContact(request.getContact());
        if (request.getCep() != null) student.setCep(request.getCep());
        if (request.getStreet() != null) student.setStreet(request.getStreet());
        if (request.getState() != null) student.setState(request.getState());
        if (request.getNeighborhood() != null) student.setNeighborhood(request.getNeighborhood());
        if (request.getCity() != null) student.setCity(request.getCity());
        if (request.getNumber() != null) student.setNumber(request.getNumber());

        StudentEntity savedStudent = studentRepository.save(student);

        return mapToResponse(savedStudent);
    }

    private StudentResponse mapToResponse(StudentEntity student) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCep(student.getCep());
        addressDto.setStreet(student.getStreet());
        addressDto.setState(student.getState());
        addressDto.setNeighborhood(student.getNeighborhood());
        addressDto.setCity(student.getCity());
        addressDto.setNumber(student.getNumber());

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setDateBirth(student.getDateBirth());
        response.setCpf(student.getCpf());
        response.setContact(student.getContact());
        response.setAddress(addressDto);
        return response;
    }

    public StudentResponse getStudentById(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        return mapToResponse(student);
    }
}
