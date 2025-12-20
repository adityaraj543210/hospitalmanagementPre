package com.codingShuttle.youtube.hospitalManagement.dto;

import com.codingShuttle.youtube.hospitalManagement.type.BloodGroupType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class BloodGroupCountRepositoryEntity {

   // @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroupType;
    private Long count;

    public BloodGroupType getBloodGroupType() {
        return bloodGroupType;
    }

    public void setBloodGroupType(BloodGroupType bloodGroupType) {
        this.bloodGroupType = bloodGroupType;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BloodGroupCountRepositoryEntity() {
    }

    public BloodGroupCountRepositoryEntity(BloodGroupType bloodGroupType, Long count) {
        this.bloodGroupType = bloodGroupType;
        this.count = count;
    }

    @Override
    public String toString() {
        return "BloodGroupCountRepositoryEntity{" +
                "bloodGroupType=" + bloodGroupType +
                ", count=" + count +
                '}';
    }
}
