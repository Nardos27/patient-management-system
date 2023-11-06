package com.et.PMS.repository;

import com.et.PMS.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long>{
}
