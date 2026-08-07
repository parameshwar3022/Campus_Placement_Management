package com.placement.PC_Management.repository;

import com.placement.PC_Management.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findByDepartmentContainingIgnoreCase(
            String department,
            Pageable pageable
    );

    Page<Student> findByCgpaGreaterThanEqual(
            Double cgpa,
            Pageable pageable
    );

    Page<Student> findBySkillsContainingIgnoreCase(
            String skill,
            Pageable pageable
    );
}