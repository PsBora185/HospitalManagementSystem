package com.pranav.SpringDataJPA.HospitalManagement.service;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.PatientResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import com.pranav.SpringDataJPA.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public void deleteById(Long pId){
        patientRepository.deleteById(pId);
    }

    public PatientResponseDto getPatientById(long pId) {
        Patient patient = patientRepository.findById(pId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+pId));
        return modelMapper.map(patient, PatientResponseDto.class);
    }

    public List<PatientResponseDto> getAllPatients(int pageNo, int pageSize){

        Page<Patient> patients = patientRepository.findAllPatients(PageRequest.of(pageNo, pageSize, Sort.by("name")));

        return patients.stream().map(patient -> modelMapper.map(patient, PatientResponseDto.class)).toList();
    }
}
