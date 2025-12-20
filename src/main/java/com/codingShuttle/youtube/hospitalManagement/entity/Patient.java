package com.codingShuttle.youtube.hospitalManagement.entity;

import com.codingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(

        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "dob"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "dob")
        }
)
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodgroup=" + bloodgroup +
                ", createdAt=" + createdAt +
                '}';
    }

}
