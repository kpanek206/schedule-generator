package com.schedule.schedule.api;


import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Schedule {

    @ValueRangeProvider(id = "scheduleRange")
    @ProblemFactCollectionProperty
    private List<Shift> shiftList;

    @ValueRangeProvider(id = "userRange")
    @PlanningEntityCollectionProperty
    private List<User> userList;

    @PlanningScore
    private HardSoftScore score;

    private Schedule (){
    }

    public Schedule(List<Shift> shiftList, List<User> userList){
        this.shiftList=shiftList;
        this.userList=userList;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public HardSoftScore getScore() {
        return score;
    }


}
