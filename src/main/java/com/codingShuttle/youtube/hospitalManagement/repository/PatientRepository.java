package com.codingShuttle.youtube.hospitalManagement.repository;

import com.codingShuttle.youtube.hospitalManagement.dto.BloodGroupCountRepositoryEntity;
import com.codingShuttle.youtube.hospitalManagement.entity.Patient;
import com.codingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    Patient findByName(String name);
    Patient findByDob(LocalDate dob);
    List<Patient> findByNameLike(String query);

    @Query("select p from Patient p where p.bloodgroup = ?1")
    List<Patient> findByBloodgroup(@Param("bloodgroup") BloodGroupType bloodgroup);

    @Query("select p from Patient p where p.dob> ?1")
    List<Patient> findByBornAfterDate(@Param("dob") LocalDate dob);

    @Query("select new com.codingShuttle.youtube.hospitalManagement.dto.BloodGroupCountRepositoryEntity (p.bloodgroup, count(p)) from Patient p group by p.bloodgroup")
    List<BloodGroupCountRepositoryEntity> countEachBloodGroupType();

    @Transactional
    @Modifying
    @Query(value = "update patient  set name = :name where id = :id", nativeQuery = true)
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query(value = "select * from patient",nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);
}
