package com.feloro.database.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Schedule")
public class Schedule {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "ScheduleID")
    private UUID scheduleId;

    @Column
    private Long state;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    public UUID getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(UUID scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
