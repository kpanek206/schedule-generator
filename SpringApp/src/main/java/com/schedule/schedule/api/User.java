package com.schedule.schedule.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class User {

    private int id;
    private String name;
    private String surname;
    private String freeDays;
    private String shiftHours;
    private String holiday;


    @PlanningVariable(valueRangeProviderRefs = "shiftRange")
    private Shift shift;

    @PlanningVariable(valueRangeProviderRefs = "scheduleRange")
    private Schedule schedule;

    private User(){

    }

    public User(int id, String name, String surname, String freeDays, String shiftHours, String holiday){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.freeDays=freeDays;
        this.shiftHours=shiftHours;
        this.holiday=holiday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFreeDays() {
        return freeDays;
    }

    public String getShiftHours() {
        return shiftHours;
    }

    public String getHoliday() {
        return holiday;
    }

    public Shift getShift() {
        return shift;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


}
