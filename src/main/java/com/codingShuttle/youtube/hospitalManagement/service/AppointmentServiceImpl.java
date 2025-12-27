package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingShuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.AppointmentRepository;
import com.codingShuttle.youtube.hospitalManagement.repository.DoctorRepository;
import com.codingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;


    @Transactional
    @Override
    public Appointment assignAppointmentToPatient(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointmentList().add(appointment);  //just to maintain bidirectinal consistency
        doctor.getAppointmentList().add(appointment);
        appointmentRepository.save(appointment);
        return appointment;

    }
}
