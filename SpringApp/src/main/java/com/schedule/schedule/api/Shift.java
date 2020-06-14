package com.schedule.schedule.api;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Shift {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    public Shift(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endtime){
        this.dayOfWeek=dayOfWeek;
        this.startTime=startTime;
        this.endTime=endtime;
    }

    public String toString(){
        return dayOfWeek + " " + startTime.toString();
    }

    public DayOfWeek getDayOfWeek(){
        return dayOfWeek;
    }
    public LocalTime getStartTime(){
        return startTime;
    }
    public LocalTime getEndTime(){
        return endTime;
    }
}
