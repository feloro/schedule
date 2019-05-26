package com.feloro.database.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Attendance")
public class Attendance {

    @Id
    @Type(type = "uuid-char")
    @Column
    private UUID attendanceId;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User user;

    @Column
    @Temporal(TemporalType.TIME)
    private Date time;

    public UUID getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(UUID attendanceId) {
        this.attendanceId = attendanceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
