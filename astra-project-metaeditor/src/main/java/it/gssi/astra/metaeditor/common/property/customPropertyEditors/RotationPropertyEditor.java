package it.gssi.astra.metaeditor.common.property.customPropertyEditors;

import java.util.Arrays;

import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.property.BeanProperty;

import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.property.CustomAbstractPropertyEditor;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class RotationPropertyEditor extends CustomAbstractPropertyEditor<Object, ComboBox<Object>>{

	public RotationPropertyEditor(Item item) {

        super(item, new ComboBox<Object>());
        
        BeanProperty beanProperty = (BeanProperty) item;
        Ente ente = (Ente) beanProperty.getBean();
        getEditor().setItems(FXCollections.observableArrayList(Arrays.<Object>asList(ente.allowedRotationPositions.toArray())));
        
	}

	@Override
	public void setValue(Object value) {
		getEditor().getSelectionModel().select(value);
	}

	@Override
	protected ObservableValue<Object> getObservableValue() {
		return getEditor().getSelectionModel().selectedItemProperty();
	}
}
