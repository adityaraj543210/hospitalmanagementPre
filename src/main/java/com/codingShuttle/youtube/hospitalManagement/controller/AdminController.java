package com.codingShuttle.youtube.hospitalManagement.controller;
import com.codingShuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.DoctorRepository;
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
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
       List<Doctor> doctorList = doctorRepository.findAll();
       return doctorList;
    }

}
