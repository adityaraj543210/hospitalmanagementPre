package com.codingShuttle.youtube.hospitalManagement;

import com.codingShuttle.youtube.hospitalManagement.dto.BloodGroupCountRepositoryEntity;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.repository.PatientRepository;
import com.codingShuttle.youtube.hospitalManagement.serviice.PatientService;
import com.codingShuttle.youtube.hospitalManagement.type.BloodGroupType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;


@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
//        List<Patient> patientList = patientRepository.findAll();
//        System.out.println(patientList);

       // Patient p2 = patientRepository.findById(2L).orElseThrow();
        //patientService.getPatientById(2L);

//        Patient p = patientRepository.findByName("Pooja Patel");
//        System.out.println(p);
////        Patient p2 = patientRepository.findByDob(LocalDate.of(1996, 4 ,12));
//
//
////        System.out.println(p2);
//
//


//        System.out.println();
////        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1888,9,21));
////        for(Patient patient : patientList) System.out.println(patient);
//        List<Object[]> objects = patientRepository.countEachBloodGroupType();
//
//        for(Object[] obj : objects){
//            System.out.println(obj[0] + " " + obj[1]);
//        }
//        int cnt = patientRepository.updateNameWithId("Raushan", 12L);
//        System.out.println(cnt);

//        List<BloodGroupCountRepositoryEntity> bloodGroupCountRepositoryEntityList = patientRepository.countEachBloodGroupType();
//
//        for(BloodGroupCountRepositoryEntity bge: bloodGroupCountRepositoryEntityList){
//            System.out.println(bge);
//        }

//        Page<Patient> patientList = patientRepository.findAllPatient(PageRequest.of(0,2));
//        for(Patient p:patientList){
//            System.out.println(p);
//        }

    }

}
