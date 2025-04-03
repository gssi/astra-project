package it.gssi.astra.metaeditor.common.property;

import org.eclipse.emf.ecore.EObject;

/**
 * Implementation of {@link Option} for {@code EReference} values
 *
 */
public class ReferencePropertyValue extends Option {
	
	/**
	 * @param name The name that will be displayed in the 
	 * list of option of CheckComboBox.
	 * @param instance The instance of EObject that will be contained in the list of options.
	 */
	public ReferencePropertyValue(String name, EObject instance) {
		this.name = name;
		this.instance = instance;
	}
	
	public static ReferencePropertyValue createEmptyProperty() {
		return new ReferencePropertyValue("Select Item", null);
	}
	
	public boolean isEmptyProperty() {
		return instance == null;
	}
	
	@Override
	public Object getInstance() {
		return (EObject) instance;
	}
}
