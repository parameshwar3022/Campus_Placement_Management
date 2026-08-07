package com.placement.PC_Management.controller;

import com.placement.PC_Management.dto.request.StudentRequest;
import com.placement.PC_Management.dto.response.StudentResponse;
import com.placement.PC_Management.service.StudentService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studentService.getStudentById(id));
    }

    // Get All Students
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    // Update Student
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentRequest request) {

        return ResponseEntity.ok(
                studentService.updateStudent(id, request));
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully.");
    }

    // Search By Department
    @GetMapping("/search/department")
    public ResponseEntity<Page<StudentResponse>> searchByDepartment(
            @RequestParam String department,
            Pageable pageable) {

        return ResponseEntity.ok(
                studentService.searchByDepartment(department, pageable));
    }

    // Search By CGPA
    @GetMapping("/search/cgpa")
    public ResponseEntity<Page<StudentResponse>> searchByCgpa(
            @RequestParam Double cgpa,
            Pageable pageable) {

        return ResponseEntity.ok(
                studentService.searchByCgpa(cgpa, pageable));
    }

    // Search By Skill
    @GetMapping("/search/skill")
    public ResponseEntity<Page<StudentResponse>> searchBySkill(
            @RequestParam String skill,
            Pageable pageable) {

        return ResponseEntity.ok(
                studentService.searchBySkill(skill, pageable));
    }
}