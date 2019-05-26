package com.feloro.controller.wrapper;

import java.util.List;
import java.util.UUID;

public class ScheduleWrapper {
    private List<Day> days;
    private UUID userId;
    private Long state;

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }
}
