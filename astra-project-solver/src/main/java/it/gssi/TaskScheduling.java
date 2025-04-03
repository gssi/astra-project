package it.gssi;

import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.util.Precision;

public class TaskScheduling {
    public static void main(String[] args) {
        // Define problem data
        int numTasks = 3;
        double[] durations = {5.0, 3.0, 4.0};
        double[] priorities = {1.0, 2.0, 3.0};
        double[] deadlines = {10.0, 8.0, 12.0};

        // Create a linear programming problem
        LinearObjectiveFunction objective = new LinearObjectiveFunction(priorities, 0.0);

        // Create constraints
        LinearConstraint[] constraintsArray = {
            new LinearConstraint(new double[]{1.0, 1.0, 1.0}, Relationship.EQ, 1.0)
        };

        LinearConstraintSet constraints = new LinearConstraintSet(constraintsArray);

        // Create LP solver
        LinearOptimizer optimizer = new SimplexSolver();
        PointValuePair solution = optimizer.optimize();

        // Get the task scheduling result
        double[] taskSchedule = solution.getPoint();
        System.out.println("Task scheduling result:");
        for (int i = 0; i < numTasks; i++) {
            if (Precision.equals(taskSchedule[i], 1.0, 1e-6)) {
                System.out.println("Task " + (i + 1) + " is scheduled.");
            }
        }
    }
}

