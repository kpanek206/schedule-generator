package com.schedule.schedule.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue
    @JsonProperty("taskId")
    private int taskId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("min")
    private String minShiftHours;
    @JsonProperty("max")
    private String maxShiftHours;
    @JsonProperty("start")
    private String startHoliday;
    @JsonProperty("end")
    private String endHoliday;

    public String getMinShiftHours() {
        return minShiftHours;
    }

    public void setMinShiftHours(String minShiftHours) {
        this.minShiftHours = minShiftHours;
    }

    public String getMaxShiftHours() {
        return maxShiftHours;
    }

    public void setMaxShiftHours(String maxShiftHours) {
        this.maxShiftHours = maxShiftHours;
    }

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStartHoliday() {
        return startHoliday;
    }

    public void setStartHoliday(String startHoliday) {
        this.startHoliday = startHoliday;
    }

    public String getEndHoliday() {
        return endHoliday;
    }

    public void setEndHoliday(String endHoliday) {
        this.endHoliday = endHoliday;
    }
}
