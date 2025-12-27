package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.InsuranceRepository;
import com.codingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService{

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Transactional
    @Override
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Doesn't exist with id"+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);
//        patientRepository.save(patient);
//        insuranceRepository.save(insurance);
        return patient;
    }
}
