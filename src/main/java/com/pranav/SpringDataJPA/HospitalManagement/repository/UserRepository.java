package com.pranav.SpringDataJPA.HospitalManagement.repository;

import com.pranav.SpringDataJPA.HospitalManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);
}
