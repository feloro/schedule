package com.feloro.service;

import com.feloro.database.domain.Schedule;
import com.feloro.database.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> findAllByUserId(UUID userId) {
        return scheduleRepository.findAllByUser_Id(userId);
    }

    public Schedule setNewState(UUID scheduleId, Long stateId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).get();
        schedule.setState(stateId);
        return scheduleRepository.save(schedule);
    }
}
