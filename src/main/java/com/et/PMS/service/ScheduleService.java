package com.et.PMS.service;

import com.et.PMS.constants.ApiMessages;
import com.et.PMS.dto.ResponseDTO;
import com.et.PMS.dto.ScheduleRequestDto;
import com.et.PMS.entities.Patient;
import com.et.PMS.entities.Schedule;
import com.et.PMS.exeption.NotFoundException;
import com.et.PMS.repository.PatientRepository;
import com.et.PMS.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final PatientRepository patientRepository;
    private final ApiMessages apiMessages = new ApiMessages();

    public ResponseDTO<?> addSchedule(ScheduleRequestDto scheduleRequestDto) {
        Patient patient = patientRepository.findById(scheduleRequestDto.getPatientId())
                .orElseThrow(()->new NotFoundException("patient not found"));
        Schedule schedule = new Schedule();
        schedule.setPatientId(patient.getId());
        schedule.setCreatedDate(ZonedDateTime.now());
        scheduleRepository.save(schedule);
        return apiMessages.successMessageWithData(schedule);
    }
}
