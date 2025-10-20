package com.pranav.SpringDataJPA.HospitalManagement.dtos;

import com.pranav.SpringDataJPA.HospitalManagement.entity.Doctor;
import com.pranav.SpringDataJPA.HospitalManagement.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponseDto {

    private Long id;
    private LocalDateTime appointmentTime;

    private String reason;

    private PatientResponseDto patient;

    private DoctorResponseDto doctor;

    @Override
    public String toString(){
        return "Id : " + this.id+
                ", Time : "+this.appointmentTime+
                ", Reason : "+this.reason+
                ", Patient : "+this.patient.getId()+
                ", Doctor : "+this.doctor.getId();
    }
}
