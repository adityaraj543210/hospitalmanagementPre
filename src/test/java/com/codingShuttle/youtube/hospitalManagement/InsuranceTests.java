package com.codingShuttle.youtube.hospitalManagement;


import com.codingShuttle.youtube.hospitalManagement.entity.Insurance;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = new Insurance();
        insurance.setProvider("HDFC");
        insurance.setPolicyNumber("HDFC_1234");
        insurance.setValidUntil(LocalDate.of(2012,11,12));

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println("hey" + patient);

    }


}
