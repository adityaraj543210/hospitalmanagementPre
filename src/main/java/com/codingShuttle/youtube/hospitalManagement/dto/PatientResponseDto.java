package com.codingShuttle.youtube.hospitalManagement.dto;

import com.codingShuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class PatientResponseDto {
    private String name;
    private String gender;
    private LocalDate dob;
    private String email;
    private BloodGroupType bloodGroup;

}
