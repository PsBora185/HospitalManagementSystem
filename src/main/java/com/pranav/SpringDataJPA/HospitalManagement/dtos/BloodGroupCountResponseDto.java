package com.pranav.SpringDataJPA.HospitalManagement.dtos;

import com.pranav.SpringDataJPA.HospitalManagement.entity.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseDto {

    private BloodGroup bloodGroupType;
    private Long count;
}
