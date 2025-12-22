package com.codingShuttle.youtube.hospitalManagement.entity;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime appointmentTime;

    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
