package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.dto.PatientResponseDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;

import java.util.List;

public interface PatientService {

    public PatientResponseDto getPatientById(Long id);
    public void deletePatientById(Long id);

    List<PatientResponseDto> getPatients();
}
