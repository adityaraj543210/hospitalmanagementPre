package com.codingShuttle.youtube.hospitalManagement.controller;


import com.codingShuttle.youtube.hospitalManagement.dto.AppointmentResponseDto;
import com.codingShuttle.youtube.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.codingShuttle.youtube.hospitalManagement.dto.PatientResponseDto;
import com.codingShuttle.youtube.hospitalManagement.service.AppointmentService;
import com.codingShuttle.youtube.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private AppointmentService appointmentService;


    @Autowired
    private PatientService patientService;

    @PostMapping("/appointments")
    public AppointmentResponseDto createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto){ //doctor id patient id reason
        return appointmentService.createNewAppointment(createAppointmentRequestDto);
    }

    @GetMapping("/profile")
    public PatientResponseDto patientResponseDto(){
        Long patientId = 3L;
        return patientService.getPatientById(patientId);
    }
}
