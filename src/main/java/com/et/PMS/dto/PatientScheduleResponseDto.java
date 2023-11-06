package com.et.PMS.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientScheduleResponseDto {
    private Long id;
    private String fullName;
    private String gender;
    @Column(unique = true)
    private String phoneNumber;
    private int age;
    private Long ScheduleId;
    private ZonedDateTime ScheduleCreatedDate;

}
