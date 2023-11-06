package com.et.PMS.service;

import com.et.PMS.constants.ApiMessages;
import com.et.PMS.dto.PatientRequestDto;
import com.et.PMS.dto.PatientScheduleResponseDto;
import com.et.PMS.dto.ResponseDTO;
import com.et.PMS.entities.Patient;
import com.et.PMS.entities.Schedule;
import com.et.PMS.repository.PatientRepository;
import com.et.PMS.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final ScheduleRepository scheduleRepository;
    private final ApiMessages apiMessages = new ApiMessages();

    public ResponseDTO<?> registerPatient(PatientRequestDto patientRequestDto) {
        Patient patient = new Patient();
        patient.setFullName(patientRequestDto.getFullName());
        patient.setGender(patientRequestDto.getGender());
        patient.setAge(patientRequestDto.getAge());
        patient.setPhoneNumber(patientRequestDto.getPhoneNumber());
        patientRepository.save(patient);
        return apiMessages.successMessageWithData(patient);
    }

    public ResponseDTO<?> getPatients() {
        List<PatientScheduleResponseDto> patientScheduleResponseDtoList = new ArrayList<>();
        List<Patient> patientList = patientRepository.findAll();
        patientList.forEach(patient -> {
            Schedule schedule = scheduleRepository.findAllByPatientId(patient.getId());
            PatientScheduleResponseDto patientScheduleResponseDto = new PatientScheduleResponseDto();
            patientScheduleResponseDto.setId(patient.getId());
            patientScheduleResponseDto.setAge(patient.getAge());
            patientScheduleResponseDto.setGender(patient.getGender());
            patientScheduleResponseDto.setPhoneNumber(patient.getPhoneNumber());
            patientScheduleResponseDto.setFullName(patient.getFullName());
            patientScheduleResponseDto.setScheduleId(schedule.getId());
            patientScheduleResponseDto.setScheduleCreatedDate(schedule.getCreatedDate());
            patientScheduleResponseDto.setFullName(patient.getFullName());
            patientScheduleResponseDtoList.add(patientScheduleResponseDto);
        });
        return apiMessages.successMessageWithListData(patientScheduleResponseDtoList);
    }
}
