package com.placement.PC_Management.dto.request;

import com.placement.PC_Management.enums.Role;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank(message = "Full Name is required")
    private String fullName;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;

    @NotNull(message = "Role is required")
    private Role role;

    // Student Fields

    private String department;

    private Double cgpa;

    private String skills;

    private String resume;

    // Recruiter Fields

    private String companyName;

    private String companyDescription;

    private String companyWebsite;

    private String companyLocation;

    private String contactPerson;

    private String contactNumber;
}