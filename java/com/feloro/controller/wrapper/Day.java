package com.feloro.controller.wrapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.feloro.database.domain.WorkShift;

import java.util.Date;

public class Day {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private WorkShift shift;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WorkShift getShift() {
        return shift;
    }

    public void setShift(WorkShift shift) {
        this.shift = shift;
    }
}
