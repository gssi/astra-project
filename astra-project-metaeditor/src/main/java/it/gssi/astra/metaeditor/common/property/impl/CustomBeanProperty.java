package it.gssi.astra.metaeditor.common.property.impl;

import java.beans.PropertyDescriptor;
import java.util.Optional;

import org.controlsfx.property.BeanProperty;
import org.controlsfx.validation.Validator;

import it.gssi.astra.metaeditor.common.property.customInterface.ICustomItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class CustomBeanProperty extends BeanProperty implements ICustomItem {
	
	private boolean required = false;
	private boolean editable = true;
	private Validator<?> validator;
	private Object defaultValue;

	public CustomBeanProperty(Object bean, PropertyDescriptor propertyDescriptor, Object defaultValue) {
		super(bean, propertyDescriptor);
		this.defaultValue = defaultValue;
	}

	@Override
	public Optional<Validator<?>> getValidator() {
		return Optional.ofNullable(validator);
	}

	public void setValidator(Validator<?> validator) {
		this.validator = validator;
	}
	
	@Override public boolean isRequired() {
		return required;
	}
	
	/**
     * @param required Whether this property should be marked as required in the PropertySheet.
     */
    public void setRequired(boolean required) {
        this.required = required;
    }
    
    /**
     * Observable for editable property.
     * 
     */
    private BooleanProperty editableProperty = new SimpleBooleanProperty(true);
    
    public BooleanProperty editableProperty() {
		return editableProperty;
	}

	@Override
	public boolean isEditable() {
		return editable;
	}

	/**
	 * @param editable Whether this property should be editable in the
	 *                 PropertySheet.
	 */
	@Override
	public void setEditable(final boolean editable) {
		this.editable = editable;
		this.editableProperty().set(editable);
	}

	@Override
	public void reset() {
		this.setValue(defaultValue);
	}

}
