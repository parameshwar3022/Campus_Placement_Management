package com.placement.PC_Management.service;

import com.placement.PC_Management.dto.request.LoginRequest;
import com.placement.PC_Management.dto.request.RegisterRequest;
import com.placement.PC_Management.dto.response.LoginResponse;
import com.placement.PC_Management.dto.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}