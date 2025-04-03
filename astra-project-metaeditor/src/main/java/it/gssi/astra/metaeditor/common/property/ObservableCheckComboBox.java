package it.gssi.astra.metaeditor.common.property;

import org.controlsfx.control.CheckComboBox;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * The {@code ObservableCheckComboBox} class extends {@link CheckComboBox} in order to
 * provide an observable for the list of checked items that is a mirror of the original
 * {@link CheckComboBox#checkModelProperty()} which is not supported by the eclipse
 * databinding for javafx that we are using.
 *
 * @param <T>
 */
public class ObservableCheckComboBox<T> extends CheckComboBox<T> {

	/**
	 * 
	 */
	public ObjectProperty<ObservableList<T>> selectedItems;

	/**
     * Creates a new CheckComboBox instance with an empty list of choices.
     * And initialize {@link ObservableCheckComboBox#selectedItems} with the name "selectedItems"
     * that will be used by {@link CustomPropertyEditorFactory#createCheckComboBoxEditor(org.controlsfx.control.PropertySheet.Item, java.util.Collection)}
     */
	public ObservableCheckComboBox() {
		super();
		selectedItems = new SimpleObjectProperty<>(this, "selectedItems");
		selectedItems.addListener(listenForSharedList);
	}

	/**
     * Creates a new CheckComboBox instance with the given items available as
     * choices.
     * 
     * @param options The options to display within the CheckComboBox.
     */
	public ObservableCheckComboBox(final ObservableList<T> options) {
		super(options);
		selectedItems = new SimpleObjectProperty<>(this, "selectedItems");
		selectedItems.addListener(listenForSharedList);
	}

	public void setSelectedItems(ObservableList<T> value) {
		selectedItemsProperty().set(value);
	}

	public ObservableList<T> getSelectedItems() {
		return selectedItems == null ? null : selectedItems.get();
	}

	public ObjectProperty<ObservableList<T>> selectedItemsProperty() {
		return selectedItems;
	}

	/**
	 * Listen for operations done on the UI and updates selectedItems that is bound to the {@code EStructuralFeature} of the domain model
	 */
	public ListChangeListener<Object> listenForCheckModel = new ListChangeListener<Object>() {

		@SuppressWarnings("unchecked")
		@Override
		public void onChanged(Change<? extends Object> c) {

			selectedItems.removeListener(listenForSharedList);
			
			ObservableList<T> selectedItems_temp = FXCollections.observableArrayList();
			
			selectedItems_temp.addAll(getSelectedItems());

			// Check for each element of selectItems_temp if it is contained in the list checked options
			// If it is not contained it will be removed
			selectedItems_temp.removeIf(element -> {
				for (T checked : ObservableCheckComboBox.this.getCheckModel().getCheckedItems()) {
					Option o = (Option) checked;

					if (element == o.getInstance()) {
						return false;
					}
				}

				return true;
			});

			// Add the new checked options to selectedItems_temp
			for (T checked : ObservableCheckComboBox.this.getCheckModel().getCheckedItems()) {
				Option o = (Option) checked;
				if (!selectedItems_temp.contains(o.getInstance())) {
					selectedItems_temp.add((T) o.getInstance());
				}
			}
			
			setSelectedItems(selectedItems_temp);

			selectedItems.addListener(listenForSharedList);

		}
	};

	/**
	 * Listen for operations done on the domain model
	 */
	public ChangeListener<Object> listenForSharedList = new ChangeListener<Object>() {

		@SuppressWarnings("unchecked")
		@Override
		public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {

			ObservableCheckComboBox.this.getCheckModel().getCheckedItems().removeListener(listenForCheckModel);

			ObservableCheckComboBox.this.getCheckModel().clearChecks();

			// For each element of selectedItems it will check the corresponding box on the UI
			for (Object element : selectedItems.getValue()) {
				for (T choice : getItems()) {
					Option o = (Option) choice;
					if (o.getInstance() == element) {
						ObservableCheckComboBox.this.getCheckModel().check((T) o);
					}
				}
			}

			ObservableCheckComboBox.this.getCheckModel().getCheckedItems().addListener(listenForCheckModel);
		}
	};

}
