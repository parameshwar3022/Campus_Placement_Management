package com.placement.PC_Management.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {

    private String department;

    private Double cgpa;

    private String skills;

    private String resume;
}