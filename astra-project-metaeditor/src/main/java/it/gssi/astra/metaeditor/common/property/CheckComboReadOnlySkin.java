package it.gssi.astra.metaeditor.common.property;

import org.controlsfx.control.CheckComboBox;

import impl.org.controlsfx.skin.CheckComboBoxSkin;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;

/**
 * Custom CheckComboBox skin that is used for uneditable features
 * Called by {@link CustomPropertyEditorFactory#createCheckComboBoxEditor}
 * @param <T>
 */
public class CheckComboReadOnlySkin<T> extends CheckComboBoxSkin<T> {
	@SuppressWarnings("unchecked")
	public CheckComboReadOnlySkin(CheckComboBox<T> control) {
		super(control);

		((javafx.scene.control.ComboBox<T>) getChildren().get(0))
				.setCellFactory((Callback<ListView<T>, javafx.scene.control.ListCell<T>>) listView -> {
					CheckBoxListCell<T> result = new CheckBoxListCell<>(item -> control.getItemBooleanProperty(item)) {
						@Override
						public void updateItem(T item, boolean empty) {
							super.updateItem(item, empty);
							
							if (control.getItemBooleanProperty(item) != null) {
								if (control.getItemBooleanProperty(item).get()) {
									// Selected
								} else {
									// Not selected
								}
							}
						}
					};

//					result.getStyleClass().add("readonly-checkbox-list-cell");
					result.setDisable(true);
					result.converterProperty().bind(control.converterProperty());
					return result;
				});
		
		ListCell<T> buttonCell = new ListCell<T>() {
            @Override protected void updateItem(T item, boolean empty) {
                setText("Show items");
            }
        };
        ((javafx.scene.control.ComboBox<T>) getChildren().get(0)).setButtonCell(buttonCell);
        ((javafx.scene.control.ComboBox<T>) getChildren().get(0)).setValue((T) "Show items");
	}
}
