package com.schedule.schedule.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

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
    @JsonProperty("freeDays")
    private String freeDays;
    @JsonProperty("shiftHours")
    private LocalTime shiftHours;
    @JsonProperty("holiday")
    private String holiday;

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

    public String getFreeDays() {
        return freeDays;
    }

    public void setFreeDays(String freeDays) {
        this.freeDays = freeDays;
    }

    public LocalTime getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(String shiftHours) {
        this.shiftHours = LocalTime.parse(shiftHours);
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }
}
