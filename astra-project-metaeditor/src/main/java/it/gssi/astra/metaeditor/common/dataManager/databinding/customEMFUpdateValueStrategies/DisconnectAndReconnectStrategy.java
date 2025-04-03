package it.gssi.astra.metaeditor.common.dataManager.databinding.customEMFUpdateValueStrategies;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.internal.EMFObservableValueDecorator;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.magnete.Magnete;

/**
 * This strategy disconnects all the anchor points of the node then tries a
 * reconnection. It is useful when changing the value of a property also changes
 * the aspect of the node (e.g. Rotation property) invalidating from a graphical
 * point of view the old connections. It also provides atomicity of all actions
 * triggered by changing the value of properties from property panel.
 * 
 * @see AtomicUpdateValueStrategy
 *
 */
public class DisconnectAndReconnectStrategy extends EMFUpdateValueStrategy {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected IStatus doSet(IObservableValue observableValue, Object value) {

		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();

		ElementPosition o = (ElementPosition) ((EMFObservableValueDecorator) observableValue).getObserved();
		Ente e = LayoutScene.getViewModelMap().get(o.getElement());
		e.dropOldConnections();
		Magnete.connect(e.getDraggableNode());

		IStatus status = super.doSet(observableValue, value);

		emfCommand.end();

		return status;
	}

}
