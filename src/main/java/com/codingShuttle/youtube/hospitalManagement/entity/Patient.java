package com.codingShuttle.youtube.hospitalManagement.entity;

import com.codingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private LocalDate dob;
    private String email;
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "bloodgroup")
    private BloodGroupType bloodgroup;



    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;


    @ToString.Exclude
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(unique = true)  //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Appointment> appointmentList;

}

