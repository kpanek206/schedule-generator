package com.schedule.schedule.solver;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.schedule.schedule.model.Schedule;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private SolverManager<Schedule, UUID> solverManager;

    @PostMapping("/solve")
    public Schedule solve(@RequestBody Schedule problem) {
        UUID problemId = UUID.randomUUID();
        // Submit the problem to start solving
        SolverJob<Schedule, UUID> solverJob = solverManager.solve(problemId, problem);
        Schedule solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }

}
