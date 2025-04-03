package it.gssi.astra.metaeditor.common.property;

import java.util.List;
import java.util.Optional;

import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.property.editor.PropertyEditor;
import org.controlsfx.validation.Validator;
import org.eclipse.core.databinding.Binding;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;

import com.sun.javafx.collections.ObservableListWrapper;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.commands.EMFCommands;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.property.customInterface.ICustomItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * <p>
 * It is a customization of {@link org.controlsfx.control.PropertySheet.Item}
 * which provides an implementation of
 * {@link org.controlsfx.control.PropertySheet.Item#isEditable()} and different
 * constructors for each type of property field that you want to provide.
 * 
 * @see CustomPropertyEditorFactory#call(Item)
 * </p>
 * 
 * <p>
 * Allows to manage the value of properties backed by a model (e.g. domain
 * and layout model) binding the value shown by the control of 
 * {@link CustomAbstractPropertyEditor#propertyEditor} to the value of
 * the attribute (or reference) found in the model.
 * </p>
 *
 */
public class BackedCustomPropertyItem implements ICustomItem {

	public EObject model;
	private String category, name;

	public ObservableList<Option> payload;
	public List<EObject> eobjectsList;

	private boolean editable = false;
	
	private boolean required = false;
	private Validator<?> validator;

	/**
	 * Create a new instance of {@code CustomPropertyItem} of type String
	 * 
	 * @param model
	 * @param category      Set the category that will contain this property item.
	 * @param attributeName is the name that will be displayed in the property view.
	 * @param value
	 * @param isEditable
	 */
	public BackedCustomPropertyItem(EObject model, String category, String attributeName, boolean isEditable) {
		this.model = model;
		this.category = category;
		this.name = attributeName;
		this.editable = isEditable;
		this.editableProperty().set(isEditable);
	}

	/**
	 * Initialize for references with upper
	 * bound equal to 1.
	 * 
	 * @param eobjectList
	 */
	public void setEObjectList(List<EObject> eobjectList) {
		this.eobjectsList = eobjectList;
	}

	/**
	 * Initialize for references with upper
	 * bound equal to -1 and attributes with upper bound equal to -1 which takes
	 * values from enumerator.
	 * 
	 * @param choices       List of {@link Option}
	 */
	public void setPayload(ObservableList<Option> choices) {
		this.payload = choices;
	}

	/**
	 * Return the type of this property item that will be used by
	 * {@link CustomPropertyEditorFactory} to instantiate the specific editor.
	 */
	@Override
	public Class<?> getType() {

		if (eobjectsList != null)
			return EObject.class;

		else if (payload != null)
			return ObservableListWrapper.class;

		else {
			EStructuralFeature feature = this.model.eClass().getEStructuralFeature(this.name);
			return feature.getEType().getInstanceClass();
		}

	}
	
	@Override public boolean isRequired() {
		return required;
	}
	
	/**
     * @param required Whether this property should be marked as required in the PropertySheet.
     */
    public void setRequired(final boolean required) {
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
	public void setEditable(final boolean editable) {
		this.editable = editable;
		this.editableProperty().set(editable);
		
		Node control = ((CustomPropertyEditorFactory) LayoutScene.getInstance().propertySheet
				.getPropertyEditorFactory()).getEditors().get(this);
		if (control != null) {
			control.setDisable(!editable);
		}
		
		if (!editable) {
			EStructuralFeature feature = this.model.eClass().getEStructuralFeature(this.name);

			if (!(this.model.eGet(feature) == feature.getDefaultValue())) {
				if (!(this.model.eGet(feature) instanceof EList && (((EList<?>) this.model.eGet(feature)).isEmpty()
						&& feature.getDefaultValue() == null))) {
					
					new EMFCommands().set(this.model, feature, SetCommand.UNSET_VALUE);
				}

			}
		}
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public Object getValue() {
		EStructuralFeature feature = this.model.eClass().getEStructuralFeature(this.name);
		return this.model.eGet(feature);
	}

	/**
	 * 
	 * 
	 */
	@Override
	public void setValue(Object value) {

	}

	@Override
	public Optional<ObservableValue<? extends Object>> getObservableValue() {
		return Optional.empty();
	}
	
	@Override
	public Optional<Validator<?>> getValidator() {
		return Optional.ofNullable(validator);
	}

	public void setValidator(Validator<?> validator) {
		this.validator = validator;
	}

	public PropertyEditor<?> getPropertyEditor() {
		return this.propertyEditor;
	}

	public void setPropertyEditor(PropertyEditor<?> editor) {
		this.propertyEditor = editor;
	}

	/**
	 * The JavaFX property control shown in the property panel.
	 */
	private PropertyEditor<?> propertyEditor;
	
	/**
	 * The binding object
	 */
	private Binding binding;
	
	public Binding getBinding() {
		return binding;
	}

	/**
	 * Bind the value of {@code propertyEditor} to the value of the property of the
	 * model.
	 * 
	 * @param propertyEditor
	 * @param observableUIProperty
	 */
	public void setPropertyEditor(PropertyEditor<?> propertyEditor, Object JFX_Object, String JFX_attribute) {

		this.propertyEditor = propertyEditor;

		if (this.model != null) {
			binding = JFX2EMF.bindValues(Contexts.PROPERTY_VALUES, this.model, this.name, JFX_Object, JFX_attribute,
					Converters.NONE);
		}
	}

	/**
	 * Bind the value of {@code propertyEditor} to the value of the property of the
	 * model with support to converters.
	 * 
	 * @param propertyEditor
	 * @param observableUIProperty
	 * @param down                 A converter that converts the value from the type
	 *                             of UI to the type of model
	 * @param up                   A converter that converts the value from the type
	 *                             of model to the type of UI
	 */
	public void setPropertyEditor(PropertyEditor<?> propertyEditor, Object JFX_Object, String JFX_attribute,
			Converters conv) {

		this.propertyEditor = propertyEditor;

		if (this.model != null) {
			binding = JFX2EMF.bindValues(Contexts.PROPERTY_VALUES, this.model, this.name, JFX_Object, JFX_attribute, conv);
		}
	}

	@Override
	public void reset() {
		EStructuralFeature feature = model.eClass().getEStructuralFeature(getName());

		EMFCommands emfCommand = new EMFCommands();
		emfCommand.begin();
		
		if (feature.isMany()) {
	    	
			// Check if the list is already empty otherwise there will be a notification of change
	    	if (((EList<?>)this.model.eGet(feature)).size() > 0) {
	    		
	    		emfCommand.set(this.model, feature, SetCommand.UNSET_VALUE);
	    	}
	    } else {
	    	if (this.model.eGet(feature) != feature.getDefaultValue()) {
				
	    		emfCommand.set(this.model, feature, SetCommand.UNSET_VALUE);
			}
	    }		
		
	    emfCommand.end();
	}

}