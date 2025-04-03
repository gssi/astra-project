package it.gssi.astra.metaeditor.common.dataManager.databinding.customEMFUpdateValueStrategies;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;

import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;

/**
 * This is the only known method to allow atomicity of all actions triggered by
 * changing the value of properties from property panel, e.g. when a toggle is
 * switched it could begin a chain of properties changes that needs to be atomic
 * to undo all of them with a single press CTRL-Z.
 *
 */
public class AtomicUpdateValueStrategy extends EMFUpdateValueStrategy {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected IStatus doSet(IObservableValue observableValue, Object value) {
		
		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();
		
		IStatus status = super.doSet(observableValue, value);
		
		emfCommand.end();
		
		return status;
	}

}
