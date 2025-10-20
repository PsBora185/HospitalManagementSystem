package com.pranav.SpringDataJPA.HospitalManagement.controller;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.AppointmentResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.dtos.AppointmentRequestDto;
import com.pranav.SpringDataJPA.HospitalManagement.dtos.PatientResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.service.AppointmentService;
import com.pranav.SpringDataJPA.HospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments/new")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(appointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile(Long patientId) {

        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }
}
