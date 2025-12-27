package com.codingShuttle.youtube.hospitalManagement;


import com.codingShuttle.youtube.hospitalManagement.entity.Appointment;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.service.AppointmentService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {
@Autowired
private AppointmentService appointmentService;


    @Test
    public void testAppointment(){
//        Appointment appointment = new Appointment();
//       appointment.setAppointmentTime(LocalDateTime.of(2022, 2, 4, 11, 11, 23));
//       appointment.setReason("Insomnia");
//       appointment.setStatus("kuch nhi ho rha hai");
//        var newAppointment=  appointmentService.assignAppointmentToPatient(appointment, 1L, 13L);
//        System.out.println(newAppointment);



    }
}
