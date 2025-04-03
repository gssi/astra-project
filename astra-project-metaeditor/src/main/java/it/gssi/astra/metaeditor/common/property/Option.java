package it.gssi.astra.metaeditor.common.property;

/**
 * The base class for options of CheckComboBox
 *
 */
public abstract class Option {
 
	public String name;
	
	protected Object instance;
	
	public String toString() {
		return name;
	}
	
	public Object getInstance() {
		return instance;
	}
}
