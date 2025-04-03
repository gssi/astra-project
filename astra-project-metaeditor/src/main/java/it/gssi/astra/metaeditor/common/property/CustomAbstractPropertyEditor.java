package it.gssi.astra.metaeditor.common.property;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.property.editor.PropertyEditor;

/**
 * @see org.controlsfx.property.editor.AbstractPropertyEditor
 */
public abstract class CustomAbstractPropertyEditor<T, C extends Node> implements PropertyEditor<T> {
    
    /**************************************************************************
     * 
     * Private fields
     * 
     **************************************************************************/

    private final Item property;
    private final C control;
    private boolean suspendUpdate;
    
    
    /**************************************************************************
     * 
     * Constructors
     * 
     **************************************************************************/
    
    /**
     * Creates an editable AbstractPropertyEditor instance for the given property
     * using the given editing control.
     * 
     * @param property The property that the instance is responsible for editing.
     * @param control The control that is responsible for editing the property.
     */
    public CustomAbstractPropertyEditor(Item property, C control) {
        this(property, control, ! property.isEditable());
    }
    
    /**
     * Creates an AbstractPropertyEditor instance for the given property
     * using the given editing control. It may be read-only or editable, based
     * on the readonly boolean parameter being true or false.
     * 
     * @param property The property that the instance is responsible for editing.
     * @param control The control that is responsible for editing the property.
     * @param readonly Specifies whether the editor should allow input or not.
     */
    @SuppressWarnings("unchecked")
	public CustomAbstractPropertyEditor(Item property, C control, boolean readonly) {
        this.control = control;
        this.property = property;
        if (! readonly) {
            getObservableValue().addListener((ObservableValue<? extends Object> o, Object oldValue, Object newValue) -> {
                if (! suspendUpdate) {
                    suspendUpdate = true;
                    CustomAbstractPropertyEditor.this.property.setValue(getValue());
                    suspendUpdate = false;
                }
            });
            
            if (property.getObservableValue().isPresent()) {
                property.getObservableValue().get().addListener((ObservableValue<? extends Object> o, Object oldValue, Object newValue) -> {
                    if (! suspendUpdate) {
                        suspendUpdate = true;
                        CustomAbstractPropertyEditor.this.setValue((T) property.getValue());
                        suspendUpdate = false;
                    }
                });
            }
            
        }
    }
    
    
    
    /**************************************************************************
     * 
     * Public API
     * 
     **************************************************************************/
    
    /**
     * Returns an {@link ObservableValue} of the property that this property
     * editor is responsible for editing. This is the editor's value, e.g. a 
     * TextField's textProperty().
     */
    protected abstract ObservableValue<T> getObservableValue();
    
    /**
     * Returns the property that this property editor is responsible for editing.
     */
    public final Item getProperty() {
        return property;
    }
        
    /**
     * {@inheritDoc}
     */
    @Override public C getEditor() {
        return control;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override public T getValue() {
        return getObservableValue().getValue();
    }
    
    /**
     * Custom method added to disable the control on property view
     * @param value
     */
    public void setReadOnly(boolean value) {
    	getEditor().setDisable(value);
    }
}
