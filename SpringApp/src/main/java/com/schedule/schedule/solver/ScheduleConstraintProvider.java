package com.schedule.schedule.solver;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.sum;
import static org.optaplanner.core.api.score.stream.Joiners.equal;

import java.util.function.Function;


import com.schedule.schedule.model.Shift;
import com.schedule.schedule.model.Task;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;


public class ScheduleConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                pierwsze(constraintFactory)
        };
    }

    // ************************************************************************
    // Hard constraints
    // ************************************************************************

    private Constraint pierwsze(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Shift.class)
                .join(Shift.class,
                        Joiners.equal(Shift::getDayOfWeek),
                        Joiners.equal(Shift::getTask))
                .penalize("Konflikt", HardSoftScore.ONE_HARD);

    }


}