package com.feloro.database.repository;

import com.feloro.database.domain.ScheduleWorkShift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScheduleWorkShiftRepository extends JpaRepository<ScheduleWorkShift, UUID> {

    public List<ScheduleWorkShift> findAllBySchedule_ScheduleId(UUID scheduleId);
}
