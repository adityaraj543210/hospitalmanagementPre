package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;

public interface InsuranceService {

    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId);
}
