package com.feloro.service;

import com.feloro.controller.wrapper.Day;
import com.feloro.controller.wrapper.ScheduleWrapper;
import com.feloro.database.domain.Schedule;
import com.feloro.database.domain.ScheduleWorkShift;
import com.feloro.database.repository.ScheduleRepository;
import com.feloro.database.repository.ScheduleWorkShiftRepository;
import com.feloro.settings.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleWorkShiftRepository scheduleWorkShiftRepository;

    @Autowired
    UserService userService;

    @Autowired
    WorkShiftService workShiftService;

    public List<Schedule> findAllByUserId(UUID userId) {
        return scheduleRepository.findAllByUser_Id(userId);
    }

    public String isPublicHoliday(String date) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(AppProperties.getCalendarLink(), HashMap.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("yep");
            return null;
        } else {
            return null;
        }
    }

    public Schedule setNewState(UUID scheduleId, Long stateId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).get();
        schedule.setState(stateId);
        return scheduleRepository.save(schedule);
    }

    public Schedule createSchedule(ScheduleWrapper wrapper) {
        Schedule schedule = new Schedule();
        schedule.setUser(userService.getUser(wrapper.getUserId()));
        schedule.setState(wrapper.getState());
        schedule = scheduleRepository.save(schedule);

        for (Day day: wrapper.getDays()) {
            ScheduleWorkShift link = new ScheduleWorkShift();
            link.setWorkShift(day.getShift());
            link.setSchedule(schedule);
            link.setDate(day.getDate());
            scheduleWorkShiftRepository.save(link);
        }
        return schedule;
    }
}
