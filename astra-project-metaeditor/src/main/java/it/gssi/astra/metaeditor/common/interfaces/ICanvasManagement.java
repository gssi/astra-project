package it.gssi.astra.metaeditor.common.interfaces;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface ICanvasManagement {
	
	public void addElement(EObject model, EObject parent, EReference domainContainmentRef);
	public void deleteSelectedItems();

}
