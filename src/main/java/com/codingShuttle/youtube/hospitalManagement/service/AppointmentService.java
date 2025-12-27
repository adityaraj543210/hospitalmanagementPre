package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import org.springframework.stereotype.Service;


public interface AppointmentService {
    public Appointment assignAppointmentToPatient(Appointment appointment, Long patientId, Long doctorId);
}
