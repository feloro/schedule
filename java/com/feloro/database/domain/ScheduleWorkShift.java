package com.feloro.database.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ScheduleWorkShift")
public class ScheduleWorkShift {

    @Id
    @Column
    private UUID ScheduleWorkShiftId;

    @ManyToOne
    @JoinColumn(name = "scheduleId", referencedColumnName = "scheduleId")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "WorkShiftId", referencedColumnName = "WorkShiftId")
    private WorkShift workShift;

    @Column
    private Date date;

    public UUID getScheduleWorkShiftId() {
        return ScheduleWorkShiftId;
    }

    public void setScheduleWorkShiftId(UUID scheduleWorkShiftId) {
        ScheduleWorkShiftId = scheduleWorkShiftId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public WorkShift getWorkShift() {
        return workShift;
    }

    public void setWorkShift(WorkShift workShift) {
        this.workShift = workShift;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
