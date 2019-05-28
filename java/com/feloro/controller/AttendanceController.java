package com.feloro.controller;

import com.feloro.controller.wrapper.CheckInWrapper;
import com.feloro.database.domain.Attendance;
import com.feloro.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/attendance/checkin")
    public Attendance checkIn(@RequestBody CheckInWrapper wrapper) {
        //String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //attendanceService.checkIn();
        return attendanceService.checkIn(wrapper.getUserId(), wrapper.getDate(), wrapper.getTime());
    }
}
