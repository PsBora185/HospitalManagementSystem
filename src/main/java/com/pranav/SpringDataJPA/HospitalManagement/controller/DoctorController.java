package com.pranav.SpringDataJPA.HospitalManagement.controller;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.AppointmentResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.service.AppointmentService;
import com.pranav.SpringDataJPA.HospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAppointmentsOfDoctor(Long id){
        return ResponseEntity.ok(appointmentService.getAllAppointmentsOfDoctor(1L));
    }
}
