package com.pranav.SpringDataJPA.HospitalManagement;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Appointment;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Insurance;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import com.pranav.SpringDataJPA.HospitalManagement.service.AppointmentService;
import com.pranav.SpringDataJPA.HospitalManagement.service.InsuranceService;
import com.pranav.SpringDataJPA.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class OtherTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);

        System.out.println(patient);

        var p = insuranceService.disassociateInsuranceFromPatient(patient.getId());

        System.out.println(p);
    }

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,4,2,30))
                .reason("Tests")
                .build();

        var newAppointment = appointmentService.createAppointment(appointment,1L, 2L);
        System.out.println(appointment);

        var reassigned = appointmentService.reasignAppointment(appointment.getId(),2L);
        System.out.println(reassigned);
    }

    @Test
    public void hwTest(){
        Appointment a1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,4,2,30))
                .reason("Tests1")
                .build();

        Appointment a2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,20,2,30))
                .reason("Tests2")
                .build();

        Appointment a3 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,4,2,30))
                .reason("Tests3")
                .build();

        System.out.println(appointmentService.createAppointment(a1,1L,3L)+"\n");
        System.out.println(appointmentService.createAppointment(a2,2L,3L)+"\n");
        System.out.println(appointmentService.createAppointment(a3,3L,3L)+"\n");

        // delete all appointments for this patient as well
        patientService.deleteById(3L);
    }
}
