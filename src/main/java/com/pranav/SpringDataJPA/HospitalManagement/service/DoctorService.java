package com.pranav.SpringDataJPA.HospitalManagement.service;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.DoctorResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Doctor;
import com.pranav.SpringDataJPA.HospitalManagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctorResponseDto> getAllDoctors() {

        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .toList();
    }
}
