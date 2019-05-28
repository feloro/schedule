package com.feloro.service;

import com.feloro.database.domain.Attendance;
import com.feloro.database.domain.User;
import com.feloro.database.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    UserService userService;

    public Attendance checkIn(UUID userId, Date date, Date time) {
        User user = userService.getUser(userId);
        List<Attendance> data = attendanceRepository.findAllByUserAndDate(user, date);
        if (data.size()==0 || data.size()==1) {
            Attendance first = new Attendance();
            first.setDate(date);
            first.setUser(user);
            first.setTime(time);
            return attendanceRepository.save(first);
        }
        return null;
    }
}
