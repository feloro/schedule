package com.feloro.service;

import com.feloro.database.domain.Attendance;
import com.feloro.database.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    public Boolean checkIn(Date date, Date time) {
        //attendanceRepository
        return null;
    }
}
