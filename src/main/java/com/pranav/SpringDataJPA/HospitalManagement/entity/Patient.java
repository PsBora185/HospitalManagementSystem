package com.pranav.SpringDataJPA.HospitalManagement.entity;

import com.pranav.SpringDataJPA.HospitalManagement.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_name_gender", columnNames = {"name", "gender"})
        },
        indexes = {
                @Index(name = "idx_patient_gender", columnList = "gender")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")  // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
//    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();
}
