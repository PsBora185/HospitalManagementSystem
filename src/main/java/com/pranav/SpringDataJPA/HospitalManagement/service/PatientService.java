package com.pranav.SpringDataJPA.HospitalManagement.service;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import com.pranav.SpringDataJPA.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public void deleteById(Long pId){
        patientRepository.deleteById(pId);
    }

    public Patient getById(long pId) {
        return patientRepository.findById(pId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+pId));
    }
}
