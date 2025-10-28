package com.pranav.SpringDataJPA.HospitalManagement.security;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.LoginRequestDto;
import com.pranav.SpringDataJPA.HospitalManagement.dtos.LoginResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.dtos.SignupResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.entity.User;
import com.pranav.SpringDataJPA.HospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDto(token, user.getId());
    }

    public SignupResponseDto signup(LoginRequestDto signupRequestDto) {

        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if (user != null) throw  new IllegalArgumentException("User Already Exist , Go to Login");

        user = User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build();

        userRepository.save(user);

        return new SignupResponseDto(user.getId(), user.getUsername());
    }
}
