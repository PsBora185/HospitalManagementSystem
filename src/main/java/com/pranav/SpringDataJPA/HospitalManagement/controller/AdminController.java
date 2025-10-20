package com.pranav.SpringDataJPA.HospitalManagement.controller;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.PatientResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(
            @RequestParam(value = "page", defaultValue = "0") int pageNo,
            @RequestParam(value = "size", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(patientService.getAllPatients(pageNo, pageSize));
    }

}
