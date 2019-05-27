package com.feloro.controller;

import com.feloro.database.domain.Attendance;
import com.feloro.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/attendance/checkin")
    public Attendance checkIn(@PathVariable("userId") UUID userId, @PathVariable("datetime") Date datetime) {
        //String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //attendanceService.checkIn();
        return attendanceService.checkIn(userId, datetime);
    }
}
