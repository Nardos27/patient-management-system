package com.et.PMS.repository;

import com.et.PMS.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findAllByPatientId(Long patientId);
}
