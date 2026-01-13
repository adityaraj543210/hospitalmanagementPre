package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.dto.DoctorResponseDto;
import com.codingShuttle.youtube.hospitalManagement.entity.Doctor;
import com.codingShuttle.youtube.hospitalManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorResponseDto> getDoctors() {
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();
        List<Doctor> doctorList = doctorRepository.findAll();
        for(Doctor doctor : doctorList){
            doctorResponseDtos.add(new DoctorResponseDto(doctor.getName(), doctor.getSpecialization(), doctor.getEmail()));
        }
        return doctorResponseDtos;
    }
}
