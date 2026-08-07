package com.placement.PC_Management.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    private Long studentId;

    private String fullName;

    private String email;

    private String department;

    private Double cgpa;

    private String skills;

    private String resume;
}