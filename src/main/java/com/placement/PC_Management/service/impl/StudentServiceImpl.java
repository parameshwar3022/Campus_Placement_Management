package com.placement.PC_Management.service.impl;

import com.placement.PC_Management.dto.request.StudentRequest;
import com.placement.PC_Management.dto.response.StudentResponse;
import com.placement.PC_Management.entity.Student;
import com.placement.PC_Management.exception.ResourceNotFoundException;
import com.placement.PC_Management.mapper.StudentMapper;
import com.placement.PC_Management.repository.StudentRepository;
import com.placement.PC_Management.service.StudentService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found"));

        return studentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found"));

        studentMapper.updateEntity(student, request);

        Student updatedStudent = studentRepository.save(student);

        return studentMapper.toResponse(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found"));

        studentRepository.delete(student);
    }

    @Override
    public Page<StudentResponse> searchByDepartment(
            String department,
            Pageable pageable) {

        return studentRepository
                .findByDepartmentContainingIgnoreCase(department, pageable)
                .map(studentMapper::toResponse);
    }

    @Override
    public Page<StudentResponse> searchByCgpa(
            Double cgpa,
            Pageable pageable) {

        return studentRepository
                .findByCgpaGreaterThanEqual(cgpa, pageable)
                .map(studentMapper::toResponse);
    }

    @Override
    public Page<StudentResponse> searchBySkill(
            String skill,
            Pageable pageable) {

        return studentRepository
                .findBySkillsContainingIgnoreCase(skill, pageable)
                .map(studentMapper::toResponse);
    }
}