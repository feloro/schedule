package com.feloro.controller;

import com.feloro.database.domain.Schedule;
import com.feloro.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping(name="/schedule")
    public List<Schedule> getSchedulesByUserId(@RequestParam UUID userId) {
        return scheduleService.findAllByUserId(userId);
    }

    @PutMapping(name="/schedule")
    public Schedule setNewState(@RequestParam Long stateId, @RequestParam UUID scheduleId) {
        return scheduleService.setNewState(scheduleId, stateId);
    }
}
