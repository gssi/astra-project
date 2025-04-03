package it.gssi.astra.metaeditor.common.dataManager.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import it.gssi.astra.metaeditor.common.LayoutScene;

public class EMFCommands {

	public void set(EObject owner, EStructuralFeature feature, Object value) {
		Command set = SetCommand.create(LayoutScene.getInstance().getEditingDomain(), owner, feature, value);
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(set);
	}

	public void add(EObject owner, EStructuralFeature feature, Object value) {
		Command add = AddCommand.create(LayoutScene.getInstance().getEditingDomain(), owner, feature, value);
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(add);
	}
	
	public void insert(EObject owner, EStructuralFeature feature, Object value) {
		
		if(feature.isMany()) {
			add(owner,feature,value);
		} else {
			set(owner,feature,value);
		}
	}

	/**
	 * Removes a domain object together with its corresponding persistence object
	 * It is recommended to run this API inside an atomic sequence.
	 * The dangling ElementPosition must not be removed from the map allElementPosition.
	 * See <a href="https://github.com/ErmesProject/ermes-project-metaeditor/issues/16">issue 16</a>.
	 * 
	 * @param owner The parent of the eObject to be removed
	 * @param feature The feature containing the eObject
	 * @param value The eObject to be removed
	 */
	public void remove(EObject owner, EStructuralFeature feature, Object value) {
		Command removeDomainEObject = RemoveCommand.create(LayoutScene.getInstance().getEditingDomain(), owner, feature, value);
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(removeDomainEObject);
	
		ElementPosition dangling = LayoutScene.getAllElementPositions().get(value);

		Command removeElementPosition = RemoveCommand.create(LayoutScene.getInstance().getEditingDomain(),
				LayoutScene.getInstance().getRootPersistence(),
				MetaEditorPersistencePackage.eINSTANCE.getMetaEditorPersistence_ElementPositions(),
				dangling);
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(removeElementPosition);
	}

	public void begin() {
		Command begin = new BeginAtomicSequenceCommand();
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(begin);
	}

	public void end() {
		Command end = new EndAtomicSequenceCommand();
		LayoutScene.getInstance().getEditingDomain().getCommandStack().execute(end);
	}

}
