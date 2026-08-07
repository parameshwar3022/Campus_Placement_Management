package com.placement.PC_Management.service.impl;

import com.placement.PC_Management.dto.request.LoginRequest;
import com.placement.PC_Management.dto.request.RegisterRequest;
import com.placement.PC_Management.dto.response.LoginResponse;
import com.placement.PC_Management.dto.response.RegisterResponse;
import com.placement.PC_Management.entity.Recruiter;
import com.placement.PC_Management.entity.Student;
import com.placement.PC_Management.entity.User;
import com.placement.PC_Management.enums.Role;
import com.placement.PC_Management.exception.ResourceNotFoundException;
import com.placement.PC_Management.exception.UserAlreadyExistsException;
import com.placement.PC_Management.repository.RecruiterRepository;
import com.placement.PC_Management.repository.StudentRepository;
import com.placement.PC_Management.repository.UserRepository;
import com.placement.PC_Management.security.jwt.JwtService;
import com.placement.PC_Management.security.service.CustomUserDetailsService;
import com.placement.PC_Management.service.AuthService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final RecruiterRepository recruiterRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthServiceImpl(
            UserRepository userRepository,
            StudentRepository studentRepository,
            RecruiterRepository recruiterRepository,
            BCryptPasswordEncoder passwordEncoder,
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.recruiterRepository = recruiterRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already registered.");
        }

        // Create User
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .active(true)
                .build();

        user = userRepository.save(user);

        // Create Student
        if (request.getRole() == Role.STUDENT) {

            Student student = Student.builder()
                    .user(user)
                    .department(request.getDepartment())
                    .cgpa(request.getCgpa())
                    .skills(request.getSkills())
                    .resume(request.getResume())
                    .build();

            studentRepository.save(student);
        }

        // Create Recruiter
        else if (request.getRole() == Role.RECRUITER) {

            Recruiter recruiter = Recruiter.builder()
                    .user(user)
                    .companyName(request.getCompanyName())
                    .companyDescription(request.getCompanyDescription())
                    .companyWebsite(request.getCompanyWebsite())
                    .companyLocation(request.getCompanyLocation())
                    .contactPerson(request.getContactPerson())
                    .contactNumber(request.getContactNumber())
                    .build();

            recruiterRepository.save(recruiter);
        }

        // Admin (TPO)
        else if (request.getRole() == Role.ADMIN) {
            // No separate Admin entity required
        }

        return RegisterResponse.builder()
                .userId(user.getUserId())
                .message("Registration Successful")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResourceNotFoundException("Invalid Email or Password");
        }

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(user.getEmail());

        String token = jwtService.generateToken(userDetails);

        return LoginResponse.builder()
                .token(token)
                .message("Login Successful")
                .build();
    }
}