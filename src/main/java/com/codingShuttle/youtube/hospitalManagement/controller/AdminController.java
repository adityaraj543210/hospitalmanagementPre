package com.codingShuttle.youtube.hospitalManagement.controller;
import com.codingShuttle.youtube.hospitalManagement.dto.DoctorResponseDto;
import com.codingShuttle.youtube.hospitalManagement.dto.PatientResponseDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.DoctorRepository;
import com.codingShuttle.youtube.hospitalManagement.service.DoctorService;
import com.codingShuttle.youtube.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/doctors")
    public List<DoctorResponseDto> getDoctors(){
       return doctorService.getDoctors();
    }

    @GetMapping("/patients")
    public List<PatientResponseDto> getPatints(){
        return patientService.getPatients();
    }

}
