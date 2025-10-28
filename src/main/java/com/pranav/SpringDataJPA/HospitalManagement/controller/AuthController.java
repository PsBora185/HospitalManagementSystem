package com.pranav.SpringDataJPA.HospitalManagement.controller;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.LoginRequestDto;
import com.pranav.SpringDataJPA.HospitalManagement.dtos.LoginResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.dtos.SignupResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    private ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    private ResponseEntity<SignupResponseDto> signup(@RequestBody LoginRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }
}
