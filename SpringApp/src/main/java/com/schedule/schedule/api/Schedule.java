package com.schedule.schedule.api;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;



@PlanningSolution
public class Schedule {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "shiftRange")
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

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}
