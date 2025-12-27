package com.codingShuttle.youtube.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private  String Specialization;

    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<Appointment> appointmentList;

//    @OneToOne(mappedBy = "headDoctor")
//    private Department department;

    @ToString.Exclude
    @ManyToMany(mappedBy = "doctorList")
    private List<Department> departmentList;


}
