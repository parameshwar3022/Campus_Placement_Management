package com.placement.PC_Management.service;

import com.placement.PC_Management.dto.request.StudentRequest;
import com.placement.PC_Management.dto.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    StudentResponse getStudentById(Long id);

    List<StudentResponse> getAllStudents();

    StudentResponse updateStudent(Long id, StudentRequest request);

    void deleteStudent(Long id);

    // Search APIs
    Page<StudentResponse> searchByDepartment(
            String department,
            Pageable pageable);

    Page<StudentResponse> searchByCgpa(
            Double cgpa,
            Pageable pageable);

    Page<StudentResponse> searchBySkill(
            String skill,
            Pageable pageable);
}