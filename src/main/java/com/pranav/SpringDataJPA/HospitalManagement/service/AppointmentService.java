package com.pranav.SpringDataJPA.HospitalManagement.service;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Appointment;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Doctor;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import com.pranav.SpringDataJPA.HospitalManagement.repository.AppointmentRepository;
import com.pranav.SpringDataJPA.HospitalManagement.repository.DoctorRepository;
import com.pranav.SpringDataJPA.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long docId, Long pId){

        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: "+docId));
        Patient patient = patientRepository.findById(pId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+pId));

        // if entity has id , means already created appointment
        if (appointment.getId() != null) throw new IllegalArgumentException("Appointment Already Exist!");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reasignAppointment(Long aptId, Long docId){

        Appointment appointment = appointmentRepository.findById(aptId)
                .orElseThrow(() -> new EntityNotFoundException("No appointments with id:"+aptId));

        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: "+docId));

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        return appointment;
    }
}
