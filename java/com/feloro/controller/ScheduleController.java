package com.feloro.controller;

import com.feloro.controller.wrapper.ScheduleWrapper;
import com.feloro.database.domain.Schedule;
import com.feloro.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<Schedule> getSchedulesByUserId(@RequestParam UUID userId) {
        return scheduleService.findAllByUserId(userId);
    }

    @GetMapping("/holiday")
    public String isPublicHoliday(@RequestParam String date){
        return scheduleService.isPublicHoliday(date);
    }

    @PutMapping("/schedule")
    public Schedule setNewState(@RequestParam Long stateId, @RequestParam UUID scheduleId) {
        return scheduleService.setNewState(scheduleId, stateId);
    }

    @PostMapping("/schedule")
    public Schedule createNewSchedule(@RequestBody ScheduleWrapper params) {
        return scheduleService.createSchedule(params);
    }
}
