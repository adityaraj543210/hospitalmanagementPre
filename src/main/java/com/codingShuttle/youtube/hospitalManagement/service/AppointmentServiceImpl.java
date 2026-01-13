package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.dto.AppointmentResponseDto;
import com.codingShuttle.youtube.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.codingShuttle.youtube.hospitalManagement.dto.DoctorResponseDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingShuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.AppointmentRepository;
import com.codingShuttle.youtube.hospitalManagement.repository.DoctorRepository;
import com.codingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public List<AppointmentResponseDto> getAllAppointmentOfDoctor(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        List<AppointmentResponseDto> appointmentResponseDtoList = new ArrayList<>();

        List<Appointment> appointments = doctor.getAppointmentList();

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto(doctor.getName(), doctor.getSpecialization(), doctor.getEmail());
        for(Appointment appointment : appointments){

            appointmentResponseDtoList.add(new AppointmentResponseDto(appointment.getId(), appointment.getAppointmentTime(), doctorResponseDto));
        }
        return appointmentResponseDtoList;
    }

    @Override
    @Transactional
    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) {
        Long doctorId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor Not found with ID: " + doctorId));
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient Not found with ID: "+patientId));

        Appointment appointment = new Appointment();
        appointment.setAppointmentTime(createAppointmentRequestDto.getAppointmentTime());
        appointment.setReason(createAppointmentRequestDto.getReason());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointmentList().add(appointment);
        appointment = appointmentRepository.save(appointment);


        AppointmentResponseDto appointmentResponseDto= new AppointmentResponseDto();
        appointmentResponseDto.setAppointmentTime(appointment.getAppointmentTime());
        appointmentResponseDto.setId(appointment.getId());
        appointmentResponseDto.setDoctorResponseDto(new DoctorResponseDto(doctor.getName(), doctor.getSpecialization(), doctor.getEmail()));
        return appointmentResponseDto;

    }
}
