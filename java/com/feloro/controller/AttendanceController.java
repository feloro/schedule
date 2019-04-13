package com.feloro.controller;

import com.feloro.database.domain.Attendance;
import com.feloro.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/attendance/checkin")
    public Attendance checkIn() {
        //String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //attendanceService.checkIn();
        return null;
    }
}
