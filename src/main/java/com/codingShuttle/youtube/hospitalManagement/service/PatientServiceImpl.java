package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.dto.PatientResponseDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;
    @Override
    @Transactional
    public PatientResponseDto getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
       PatientResponseDto patientResponseDto = new PatientResponseDto(p1.getName(), p1.getGender(), p1.getDob(), p1.getEmail(), p1.getBloodgroup());
        return patientResponseDto;
    }

    @Transactional
    public void deletePatientById(Long id){
        patientRepository.deleteById(1L);
    }

    @Override
    public List<PatientResponseDto> getPatients() {
        List<Patient>  patientList = patientRepository.findAll();

        List<PatientResponseDto> patientResponseDtos = new ArrayList<>();
        for(Patient patient : patientList){
            patientResponseDtos.add(new PatientResponseDto(patient.getName(), patient.getGender(),patient.getDob(),patient.getEmail(),
                    patient.getBloodgroup()));
        }
        return patientResponseDtos;
    }
}
