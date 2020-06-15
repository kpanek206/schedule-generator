package com.schedule.schedule.model;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;


@PlanningSolution
public class Schedule {

    @PlanningEntityCollectionProperty
    private List<Shift> shifts;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "task")
    private List<Task> tasks;

    @PlanningScore
    private HardSoftScore score;

    public Schedule() {
    }

    public Schedule(List<Shift> shifts, List<Task> tasks) {
        this.shifts = shifts;
        this.tasks = tasks;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public List<Task> getTask() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}