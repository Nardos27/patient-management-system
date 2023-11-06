package com.et.PMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDto {
    private String fullName;
    private String gender;
    private int age;
    private String phoneNumber;

}
