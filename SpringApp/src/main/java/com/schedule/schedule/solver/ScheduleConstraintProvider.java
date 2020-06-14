package com.schedule.schedule.solver;

import com.schedule.schedule.api.Shift;
import com.schedule.schedule.api.User;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

public class ScheduleConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
             userConflict(constraintFactory)
        };

    }

    private Constraint userConflict(ConstraintFactory constraintFactory){
        return constraintFactory.from(User.class)
                .join(User.class,
                        Joiners.equal(User::getShift),
                        Joiners.lessThan(User::getId))
                .penalize("User conflict", HardSoftScore.ONE_HARD);
    }
}
