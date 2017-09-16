package com.tsi.softenf.lab1;

import com.tsi.softenf.lab1.exceptions.DateException;

import java.util.Date;

public class Task {
    private Date startDate;
    private Date endDate;

    public Task(Date startDate, Date endDate) throws DateException {
        if (startDate.after(endDate)) {
            throw new DateException("Start date cannot be after end date.");
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
