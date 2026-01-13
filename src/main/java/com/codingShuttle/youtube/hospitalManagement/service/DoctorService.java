package com.codingShuttle.youtube.hospitalManagement.service;

import com.codingShuttle.youtube.hospitalManagement.dto.DoctorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService{
    public List<DoctorResponseDto> getDoctors();
}
