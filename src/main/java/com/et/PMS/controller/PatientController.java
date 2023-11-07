package com.et.PMS.controller;


import com.et.PMS.dto.PatientRequestDto;
import com.et.PMS.dto.ResponseDTO;
import com.et.PMS.entities.Patient;
import com.et.PMS.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class PatientController {
    private final PatientService patientService;
    @Autowired
    private static final String JSON = MediaType.APPLICATION_JSON_VALUE;

    @PostMapping(value = "/patient/register")
    public ResponseDTO<?> registerPatient(@RequestBody PatientRequestDto patientRequestDto ){
        return patientService.registerPatient(patientRequestDto);
    }
    @GetMapping(value = "/patients")
    public ResponseDTO<?> getPatients(){
        return patientService.getPatients();
    }
}
