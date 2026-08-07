package com.placement.PC_Management.mapper;

import com.placement.PC_Management.dto.request.StudentRequest;
import com.placement.PC_Management.dto.response.StudentResponse;
import com.placement.PC_Management.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    // Convert Student Entity -> StudentResponse
    public StudentResponse toResponse(Student student) {

        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .fullName(student.getUser().getFullName())
                .email(student.getUser().getEmail())
                .department(student.getDepartment())
                .cgpa(student.getCgpa())
                .skills(student.getSkills())
                .resume(student.getResume())
                .build();
    }

    // Update Student Entity using StudentRequest
    public void updateEntity(Student student, StudentRequest request) {

        student.setDepartment(request.getDepartment());
        student.setCgpa(request.getCgpa());
        student.setSkills(request.getSkills());
        student.setResume(request.getResume());
    }
}