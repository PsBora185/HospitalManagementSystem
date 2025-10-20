package com.pranav.SpringDataJPA.HospitalManagement.dtos;

import lombok.Data;

@Data
public class DoctorResponseDto {

    private Long id;

    private String name;

    private String email;

    private String specialization;

}
