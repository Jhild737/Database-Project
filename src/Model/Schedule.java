/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author tojol
 */
public class Schedule {
    private int staffNo;
    private Date date;

    @Override
    public String toString() {
        return "Schedule{" + "staffNo=" + staffNo + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
    private LocalTime startTime;
    private LocalTime endTime;

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getStaffNo() {
        return staffNo;
    }

    public Date getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Schedule(int staffNo, Date date, LocalTime startTime, LocalTime endTime) {
        this.staffNo = staffNo;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
