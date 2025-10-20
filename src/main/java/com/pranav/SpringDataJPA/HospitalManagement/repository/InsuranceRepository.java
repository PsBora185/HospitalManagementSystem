package com.pranav.SpringDataJPA.HospitalManagement.repository;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}