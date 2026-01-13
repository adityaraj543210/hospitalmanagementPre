package com.codingShuttle.youtube.hospitalManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoctorResponseDto {
    private String name;
    private String specialization;
    private String email;
}
