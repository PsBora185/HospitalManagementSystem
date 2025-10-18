package com.pranav.SpringDataJPA.HospitalManagement.service;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Insurance;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import com.pranav.SpringDataJPA.HospitalManagement.repository.InsuranceRepository;
import com.pranav.SpringDataJPA.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);  // bidirectional consistency maintenance

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+patientId));

        patient.setInsurance(null);

        return patient;
    }
}
