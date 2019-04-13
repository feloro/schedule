package com.feloro.database.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ScheduleWorkShift")
public class ScheduleWorkShift {

    @Id
    @Type(type = "uuid-char")
    @Column
    private UUID scheduleWorkShiftId;

    @ManyToOne
    @JoinColumn(name = "scheduleId", referencedColumnName = "scheduleId")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "WorkShiftId", referencedColumnName = "WorkShiftId")
    private WorkShift workShift;

    @Column
    private Date date;

    public UUID getScheduleWorkShiftId() {
        return scheduleWorkShiftId;
    }

    public void setScheduleWorkShiftId(UUID scheduleWorkShiftId) {
        this.scheduleWorkShiftId = scheduleWorkShiftId;
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
