package com.pranav.SpringDataJPA.HospitalManagement.dtos;

import com.pranav.SpringDataJPA.HospitalManagement.entity.type.BloodGroup;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto {

    private Long id;
    private String name;

    private String gender;

    private LocalDate dob;

    private BloodGroup bloodGroup;
}
