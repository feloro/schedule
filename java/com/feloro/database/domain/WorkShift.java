package com.feloro.database.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "workshift")
public class WorkShift {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "workshiftid")
    private UUID workShiftId;

    @Column
    private Long start;

    @Column
    private Long finish;

    @Column(name = "breaktime")
    private Long breakTime;

    public UUID getWorkShiftId() {
        return workShiftId;
    }

    public void setWorkShiftId(UUID workShiftId) {
        this.workShiftId = workShiftId;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getFinish() {
        return finish;
    }

    public void setFinish(Long finish) {
        this.finish = finish;
    }

    public Long getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Long breakTime) {
        this.breakTime = breakTime;
    }
}
