package com.codingShuttle.youtube.hospitalManagement.controller;


import com.codingShuttle.youtube.hospitalManagement.dto.DoctorResponseDto;
import com.codingShuttle.youtube.hospitalManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/public")
@RestController
public class HospitalController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<DoctorResponseDto> getAllDoctors(){
        return doctorService.getDoctors();
    }
}
