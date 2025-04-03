package it.gssi.astra.metaeditor.common.property.customInterface;

import java.util.Optional;

import org.controlsfx.control.PropertySheet;
import org.controlsfx.validation.Validator;

import javafx.beans.property.BooleanProperty;

public interface ICustomItem extends PropertySheet.Item {

	/**
	 * Indicates whether the PropertySheet should mark this property as required.
	 * The default implementation returns false.
	 */
	default public boolean isRequired() {
		return false;
	}
	
	/**
	 * This is an observable useful to hide reset button.
     * Indicates whether this property should be editable in the PropertySheet.
     * Must be overridden by subclasses.
     */
	default public BooleanProperty editableProperty() {
		return null;
	}
	
	/**
	 * Returns an Optional wrapping the function that 
     * should be used to validate this item. The default implementation 
     * returns Optional.empty()
     * */
	default public Optional<Validator<?>> getValidator() {
		return Optional.empty();
	}
	
	/**
	 * Resets the item to default value
	 * Overriding is optional because some implementations could not
	 * be backed by an observable.
	 */
	default public void reset() {
		return;
	}
}
