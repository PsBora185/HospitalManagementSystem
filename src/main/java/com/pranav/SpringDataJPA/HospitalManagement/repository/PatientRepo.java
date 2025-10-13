package com.pranav.SpringDataJPA.HospitalManagement.repository;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);
}
