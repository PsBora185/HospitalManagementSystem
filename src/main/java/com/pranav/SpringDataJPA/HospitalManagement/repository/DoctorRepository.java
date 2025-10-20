package com.pranav.SpringDataJPA.HospitalManagement.repository;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}