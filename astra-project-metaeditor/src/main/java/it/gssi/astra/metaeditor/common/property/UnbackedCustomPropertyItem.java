package it.gssi.astra.metaeditor.common.property;

import java.util.Optional;

import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.validation.Validator;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.property.customInterface.ICustomItem;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

/**
 * <p>
 * Provides a customization of {@link org.controlsfx.control.PropertySheet.Item}
 * which provides an implementation of
 * {@link org.controlsfx.control.PropertySheet.Item#isEditable()} and different
 * constructors for each type of property field that you want to provide. Allows
 * to manage the value of properties which are not backed by a model (e.g.
 * "Visibility Pivot" and "Visibility Bend points"}.
 * 
 * @see CustomPropertyEditorFactory#call(Item)
 * </p>
 *
 */
public class UnbackedCustomPropertyItem implements ICustomItem {

	private String category, name;
	private Object value;

	private boolean editable = false;
	
	private boolean required = false;
	private Validator<?> validator;

	private SetAttribute alg;

	/**
	 * Default constructor
	 * 
	 * @param alg        It must be a lambda expression implementing
	 *                   {@link SetAttribute}
	 * @param key        It is a string composed by two substring separated by hash
	 *                   sign, where the first one is the category that will contain
	 *                   this property item, while the second is the name that will
	 *                   be displayed.
	 * @param value
	 * @param isEditable
	 */
	public UnbackedCustomPropertyItem(SetAttribute alg, String key, Object value, boolean isEditable) {
		String[] skey = key.split("#");

		category = skey[0];
		name = skey[1];
		this.value = value;
		this.alg = alg;
		this.editable = isEditable;
	}

	/**
	 * Return the type of this property item that will be used by
	 * {@link CustomPropertyEditorFactory} to instantiate the specific editor.
	 */
	@Override
	public Class<?> getType() {

		if (value != null)
			return value.getClass();

		else
			return null;

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
		Node control = ((CustomPropertyEditorFactory) LayoutScene.getInstance().propertySheet
				.getPropertyEditorFactory()).getEditors().get(this);
		if (control != null) {
			control.setDisable(!editable);
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
		return value;
	}

	/**
	 * Calls the lambda expression passing the new value coming from UI as parameter
	 * 
	 * 
	 * 
	 */
	@Override
	public void setValue(Object value) {
		if (alg != null)
			alg.operate(value);
		// Check if necessary
		this.value = value;
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

}