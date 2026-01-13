package com.codingShuttle.youtube.hospitalManagement.controller;

import com.codingShuttle.youtube.hospitalManagement.dto.AppointmentResponseDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingShuttle.youtube.hospitalManagement.repository.DoctorRepository;
import com.codingShuttle.youtube.hospitalManagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<AppointmentResponseDto> getAllAppointmentOfDoctor(){
        return appointmentService.getAllAppointmentOfDoctor(13L);
    }
}
