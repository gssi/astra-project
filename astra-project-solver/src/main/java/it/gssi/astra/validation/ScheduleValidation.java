package it.gssi.astra.validation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

import java.io.File;
import java.util.Collection;

public class ScheduleValidation {
    public static void main(String[] args) throws Exception {
        // Load the EVL script
        EvlModule module = new EvlModule();
        module.parse(new File("checkCpuUsage.evl"));

        // Load your model
        IModel model = ModelLoader.loadModel(
            "SchedulerModel",
            "models/schedule.model",
            "metamodels/scheduler.ecore",
            true, true
        );

        module.getContext().getModelRepository().addModel(model);

        // Execute EVL
        module.execute();

        // Print unsatisfied constraints
        Collection<UnsatisfiedConstraint> results = module.getContext()
                                                          .getUnsatisfiedConstraints();
        for (UnsatisfiedConstraint uc : results) {
            System.out.println(uc.getMessage());
        }
    }
}