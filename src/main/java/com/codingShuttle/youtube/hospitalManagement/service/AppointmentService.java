package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.dto.AppointmentResponseDto;
import com.codingShuttle.youtube.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AppointmentService {
    public Appointment assignAppointmentToPatient(Appointment appointment, Long patientId, Long doctorId);

    public List<AppointmentResponseDto> getAllAppointmentOfDoctor(long l);

   public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto);
}
