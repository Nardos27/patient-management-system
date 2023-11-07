package com.et.PMS.controller;

import com.et.PMS.dto.ResponseDTO;
import com.et.PMS.dto.ScheduleRequestDto;
import com.et.PMS.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ScheduleController {
    @Autowired
    private final ScheduleService scheduleService;
    private static final String JSON = MediaType.APPLICATION_JSON_VALUE;
    @PostMapping(value = "schedule/register")
    public ResponseDTO<?> addSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto ){
        return scheduleService.addSchedule(scheduleRequestDto);
    }
}





















