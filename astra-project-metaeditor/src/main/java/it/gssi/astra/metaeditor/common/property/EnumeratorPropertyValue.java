package it.gssi.astra.metaeditor.common.property;

import org.eclipse.emf.common.util.Enumerator;

/**
 * Implementation of {@link Option} for {@code EEnumerator} values
 *
 */
public class EnumeratorPropertyValue extends Option {
	
	/**
	 * @param name The name that will be displayed in the 
	 * list of option of CheckComboBox.
	 * @param instance The enumerator of domain meta-model
	 */
	public EnumeratorPropertyValue(String name, Enumerator instance) {
		this.name = name;
		this.instance = instance;
	}
	
	public static EnumeratorPropertyValue createEmptyProperty() {
		return new EnumeratorPropertyValue("Select Item", null);
	}
	
	public boolean isEmptyProperty() {
		return instance == null;
	}

	@Override
	public Object getInstance() {
		return (Enumerator) instance;
	}
}
