package com.feloro.service;

import com.feloro.controller.wrapper.Day;
import com.feloro.controller.wrapper.ScheduleWrapper;
import com.feloro.database.domain.Schedule;
import com.feloro.database.domain.ScheduleWorkShift;
import com.feloro.database.repository.ScheduleRepository;
import com.feloro.database.repository.ScheduleWorkShiftRepository;
import com.feloro.settings.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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

    public String isPublicHoliday(Date date) {
        RestTemplate restTemplate = new RestTemplate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String url = AppProperties.getCalendarLink()
                +"&year="+calendar.get(Calendar.YEAR)
                +"&month="+(calendar.get(Calendar.MONTH)+1)
                +"&day="+calendar.get(Calendar.DAY_OF_MONTH);
        ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(url, HashMap.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ArrayList<Map<String, String>> holidays = (ArrayList<Map<String, String>>) responseEntity.getBody().get("holidays");
            if (holidays.isEmpty()) {
                return null;
            } else {
                return holidays.get(0).get("name");
            }
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
