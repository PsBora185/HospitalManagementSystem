package com.pranav.SpringDataJPA.HospitalManagement;

import com.pranav.SpringDataJPA.HospitalManagement.dtos.BloodGroupCountResponseDto;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import com.pranav.SpringDataJPA.HospitalManagement.repository.PatientRepository;
import com.pranav.SpringDataJPA.HospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientList = patientRepository.findAllPatientsWithAppointments();
        System.out.println(patientList);


    }

    @Test
    public void testTransactionMethods() {

//        Patient patient = patientService.getById(1L);
//
//        Patient patient = patientRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("Patient not " +
//                "found with id: 1"));
//
//        Patient patient = patientRepository.findByName("Diya Patel");
//
//        List<Patient> patientList = patientRepository.findByDobOrEmail(LocalDate.of(1988, 3, 15), "diya" +
//                ".patel@example.com");
//
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1993, 3, 14));

        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(1, 2, Sort.by("name")));

        for(Patient patient: patientList) {
            System.out.println(patient);
        }

        int rowsUpdated = patientRepository.updateNameWithId("Arav Sharma", 1L);
        System.out.println(rowsUpdated);

        List<BloodGroupCountResponseDto> bloodGroupList = patientRepository.countEachBloodGroupType();
        for(BloodGroupCountResponseDto bloodGroupCountResponse: bloodGroupList) {
            System.out.println(bloodGroupCountResponse);
        }
    }
}
