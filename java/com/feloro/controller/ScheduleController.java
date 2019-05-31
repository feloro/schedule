package com.feloro.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.feloro.controller.wrapper.ScheduleWrapper;
import com.feloro.database.domain.Schedule;
import com.feloro.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedule")
    public List<ScheduleWrapper> getSchedulesByUserId(@RequestParam UUID userId) {
        return scheduleService.findAllByUserId(userId).stream().map(it->{
            ScheduleWrapper wrapper = new ScheduleWrapper();
            wrapper.setState(it.getState());
            wrapper.setUserId(it.getUser().getId());
            wrapper.setDays(scheduleService.getDaysByScheduleId(it.getScheduleId()));
            wrapper.setScheduleID(it.getScheduleId());
            return wrapper;
        }).collect(Collectors.toList());
    }

    @GetMapping("/holiday")
    public String isPublicHoliday(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date date){
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
