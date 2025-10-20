package com.pranav.SpringDataJPA.HospitalManagement.repository;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}