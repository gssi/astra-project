package it.gssi.astra.metaeditor.common.property;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Collections;

import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.property.editor.*;
import org.eclipse.emf.ecore.EObject;

import com.google.common.primitives.Primitives;
import com.sun.javafx.collections.ObservableListWrapper;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.property.NumericField.NumericValidator;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * This class is a replacement for {@link org.controlsfx.property.editor.DefaultPropertyEditorFactory}.
 * 
 * It adds to {@link org.controlsfx.control.PropertySheet} the support for new editors ToogleEditor,
 * EnumChoiceEditor, CollectionChoiceEditor, CheckComboBoxEditor, AnchorRefLabel
 * 
 * 
 * 
 */
public class CustomPropertyEditorFactory implements Callback<Item, PropertyEditor<?>> {
	
	private Map<String, BackedCustomPropertyItem> items = new HashMap<String, BackedCustomPropertyItem>();
	
	public Map<String, BackedCustomPropertyItem> getItems() {
		return items;
	}
	
	private Map<Item, Node> editors = new HashMap<Item, Node>();
	
	public Map<Item, Node> getEditors() {
		return editors;
	}

	/**
	 *
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public PropertyEditor<?> call(Item item) {
		
		Class<?> type = item.getType();

		if (item.getPropertyEditorClass().isPresent()) {
			Optional<PropertyEditor<?>> ed = Editors.createCustomEditor(item);
			if (ed.isPresent())
				return ed.get();
		}

		if (/* type != null && */ type == String.class) {
			
			PropertyEditor<?> textField = Editors.createTextEditor(item);
			editors.put(item, textField.getEditor());
			
			enableEnter((TextInputControl) textField.getEditor());
			disableJavaFXUndoManager((TextInputControl) textField.getEditor());
			
			if (item instanceof BackedCustomPropertyItem) {
				BackedCustomPropertyItem temp = (BackedCustomPropertyItem) item;
				
				items.put(temp.getName(), temp);
				
				temp.setPropertyEditor(textField, (TextField) textField.getEditor(), "text");			
			}
			
			return textField;
		}

		if (/* type != null && */ isNumber(type)) {
			
			PropertyEditor<?> pe = createNumericEditor(item);
			editors.put(item, pe.getEditor());
			
			if (item instanceof BackedCustomPropertyItem) {
				BackedCustomPropertyItem temp = (BackedCustomPropertyItem) item;
				
				items.put(temp.getName(), temp);
				
				temp.setPropertyEditor(pe, (TextField) pe.getEditor(), "text", Converters.EINT_STRING);			
			}
			
			return pe;
			
		}

		if (/* type != null && */(type == boolean.class || type == Boolean.class)) {
			
			PropertyEditor<?> pe = createToggleEditor(item);
			editors.put(item, pe.getEditor());
			
			if (item instanceof BackedCustomPropertyItem) {
				BackedCustomPropertyItem temp = (BackedCustomPropertyItem) item;
				
				items.put(temp.getName(), temp);
				
				temp.setPropertyEditor(pe, (ToggleSwitch) pe.getEditor(), "selected", Converters.APPLY_ATOMICITY);			
			}
			
			return pe;
		}

		if (/* type != null && */type == LocalDate.class) {
			
			PropertyEditor<?> pe = Editors.createDateEditor(item);
			editors.put(item, pe.getEditor());
			
			return pe;
		}

		if (/* type != null && */type == Color.class || type == Paint.class) {
			
			PropertyEditor<?> pe = Editors.createColorEditor(item);
			editors.put(item, pe.getEditor());
			
			return pe;
		}

		// Lista per scegliere il valore di un attributo single-value
		if (type != null && type.isEnum()) {
			
			PropertyEditor<?> pe = createEnumChoiceEditor(item, Arrays.<Object>asList(type.getEnumConstants()));
			editors.put(item, pe.getEditor());
			
			if (item instanceof BackedCustomPropertyItem) {
				BackedCustomPropertyItem temp = (BackedCustomPropertyItem) item;
				
				items.put(temp.getName(), temp);
				
				temp.setPropertyEditor(pe, (ComboBox) pe.getEditor(), "value", Converters.APPLY_ATOMICITY);
			}

			return pe;
		}

		if (/* type != null && */type == Font.class) {
			
			PropertyEditor<?> pe = Editors.createFontEditor(item);
			editors.put(item, pe.getEditor());
			
			enableEnter((TextInputControl) pe.getEditor());
			return pe;
		}

		// Lista per scegliere il valore di ref single-value
		if (type != null && type == EObject.class) {
			
			BackedCustomPropertyItem refProperty = (BackedCustomPropertyItem) item;
			
			PropertyEditor<?> pe = createCollectionChoiceEditor(item, refProperty.eobjectsList);
			editors.put(item, pe.getEditor());
			
			if (item instanceof BackedCustomPropertyItem) {
				BackedCustomPropertyItem temp = (BackedCustomPropertyItem) item;
				
				items.put(temp.getName(), temp);
				
				temp.setPropertyEditor(pe, (ComboBox) pe.getEditor(), "value");
			}
			
			return pe;
		}

		// Lista per scegliere i valori di un attributo o ref multi-valore
		if (type != null && (type == ObservableListWrapper.class
				|| type.toString().equals("class org.controlsfx.control.CheckBitSetModelBase$2"))) {
			
			
			BackedCustomPropertyItem mulRefProp = (BackedCustomPropertyItem) item;
			
			items.put(mulRefProp.getName(), mulRefProp);
			
			PropertyEditor<?> pe = createCheckComboBoxEditor(item, mulRefProp.payload);
			editors.put(item, pe.getEditor());
			
			mulRefProp.setPropertyEditor(pe, (ObservableCheckComboBox) pe.getEditor(), "selectedItems", Converters.ELIST_LIST);

			return pe;
		}

		if (type != null && type == AnchorPoint.class) {
			
			PropertyEditor<?> pe = createAnchorRefLabel(item);
			editors.put(item, pe.getEditor());
			
			return pe;
		}

		return null;
	}

	private static Class<?>[] numericTypes = new Class[] { byte.class, Byte.class, short.class, Short.class, int.class,
			Integer.class, long.class, Long.class, float.class, Float.class, double.class, Double.class,
			BigInteger.class, BigDecimal.class };

	// there should be better ways to do this
	private static boolean isNumber(Class<?> type) {
		if (type == null)
			return false;
		for (Class<?> cls : numericTypes) {
			if (type == cls)
				return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
    public static final PropertyEditor<?> createNumericEditor( Item property ) {

    	return new AbstractPropertyEditor<Number, NumericField>(property, new NumericField( (Class<? extends Number>) property.getType())) {

			private Class<? extends Number> sourceClass = (Class<? extends Number>) property.getType(); //Double.class;
            
            {
            	enableAutoSelectAll(getEditor());
            	disableJavaFXUndoManager(getEditor());
            }

            @Override protected ObservableValue<Number> getObservableValue() {
                return getEditor().valueProperty();
            }

            /**
             * Returns the current value in the editor - this may not be the value of
             * the property itself!
             */
            @Override public Number getValue() {
                try {
                    return Primitives.wrap(sourceClass).getConstructor(String.class).newInstance(getEditor().getText());
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /**
             * Sets the value to display in the editor - this may not be the value of 
             * the property itself - and the property value will not change!
             */
            @Override public void setValue(Number value) {
                sourceClass = (Class<? extends Number>) value.getClass();
                getEditor().setValue(value);
                getEditor().setText(value.toString());
            }
            
        };   
    }
	
	/**
	 * Create a new editor for {@code EAttribute} which takes value from {@code EEnumerator}.
	 * 
	 * @param <T>
	 * @param property
	 * @param choices
	 * @return
	 */
	public static final <T> PropertyEditor<?> createEnumChoiceEditor( Item property, final Collection<T> choices ) {
        
        return new CustomAbstractPropertyEditor<T, ComboBox<T>>(property, new ComboBox<T>()) {
            
            { 
            	getEditor().setItems(FXCollections.observableArrayList(choices));
            
            	StringConverter<T> converter = new StringConverter<T>() {
	            	@SuppressWarnings("rawtypes")
					@Override public String toString(T t) {
	                    return t == null ? null : ((Enum) t).name();
	                }
	
					@Override
					public T fromString(String string) {
						//TODO New feature: For editable combobox the input string should be converted to enum
						return null;
					}
	
	            };
            	getEditor().setConverter((StringConverter<T>) converter);
            }
            
            @Override protected ObservableValue<T> getObservableValue() {
                return getEditor().getSelectionModel().selectedItemProperty();
            }

            /**
             * Sets the value to display in the editor - this may not be the value of 
             * the property itself - and the property value will not change!
             */
            @Override public void setValue(T value) {
                getEditor().getSelectionModel().select(value);
            }
        };
    }

	/**
	 * Create a new editor for boolean properties using {@link ToggleSwitch}
	 * @param property
	 * @return the new PropertyEditor
	 */
	public static final PropertyEditor<?> createToggleEditor(Item property) {

		return new CustomAbstractPropertyEditor<Boolean, ToggleSwitch>(property, new ToggleSwitch()) {

			@Override
			protected BooleanProperty getObservableValue() {
				return getEditor().selectedProperty();
			}

			/**
		     * Sets the value to display in the editor - this may not be the value of 
		     * the property itself - and the property value will not change!
		     */
			@Override
			public void setValue(Boolean value) {
				getEditor().setSelected((Boolean) value);
			}
		};

	}

	/**
	 * 
	 * Create a new editor for {@code EReference} with upper bound equal to 1.
	 * @param <T>
	 * @param property
	 * @param choices
	 * @return
	 */
	public static final <T> PropertyEditor<?> createCollectionChoiceEditor(Item property, final Collection<T> choices) {

		return new CustomAbstractPropertyEditor<T, ComboBox<T>>(property, new ComboBox<>()) {

			{
				Collections.sort((List<T>) choices, (a, b) -> 
				(LayoutScene.getViewModelMap().get((EObject) a)).getIdentifier().compareToIgnoreCase(
						(LayoutScene.getViewModelMap().get((EObject) b)).getIdentifier()));
				
				getEditor().getItems().setAll(choices);
				
				StringConverter<T> converter = new StringConverter<T>() {

					@Override public String toString(T t) {
						Ente ente = null;
						if (t != null)
							ente = LayoutScene.getViewModelMap().get((EObject) t);
						
						if (ente != null)
							return ente.getIdentifier();
						else
							return null;
	                }
	
					@Override
					public T fromString(String string) {
						// TODO New feature: For editable combobox the input string should be converted to enum
						return null;
					}
	
	            };
            	getEditor().setConverter((StringConverter<T>) converter);
			}

			@Override
			protected ObservableValue<T> getObservableValue() {
				return getEditor().getSelectionModel().selectedItemProperty();
			}

			/**
		     * Sets the value to display in the editor - this may not be the value of 
		     * the property itself - and the property value will not change!
		     */
			@Override
			public void setValue(T checked) {
				getEditor().getSelectionModel().select(checked);

			}
		};
	}

	/**
	 * Create a new editor for {@code EReference} with upper bound equal to -1
	 * and {@code EAttribute} with upper bound equal to -1 which takes values from {@code EEnumerator}.
	 * 
	 * @param <T>
	 * @param item
	 * @param choices Collection of {@link Option} compatible with this property as defined in the domain meta-model.
	 * @return
	 */
	public final <T> PropertyEditor<?> createCheckComboBoxEditor(Item item, final Collection<T> choices) {

		return new CustomAbstractPropertyEditor<ObservableList<T>, ObservableCheckComboBox<T>>(item, new ObservableCheckComboBox<>()) {

			private ListProperty<T> list;

			{
				Collections.sort((List<T>) choices, (a, b) -> (((Option) a).name.compareToIgnoreCase(((Option) b).name)));
				getEditor().getItems().setAll(choices);
			}

			@Override
			protected ListProperty<T> getObservableValue() {
				if (list == null) {
					list = new SimpleListProperty<>(getEditor().getCheckModel().getCheckedItems());
				}
				return list;
			}

			/**
		     * Sets the value to display in the editor - this may not be the value of 
		     * the property itself - and the property value will not change!
		     */
			@Override
			public void setValue(ObservableList<T> checked) {
				checked.forEach(getEditor().getCheckModel()::check);
			}
			
			@Override
			public void setReadOnly(boolean value) {
				if (value) {
					getEditor().setSkin(new CheckComboReadOnlySkin<>(getEditor()));
				}
			}
		};
	}

	/**
	 * Create a new editor based on TextField for properties of type {@link AnchorPoint}.
	 * @param property
	 * @return
	 */
	public static final PropertyEditor<?> createAnchorRefLabel(Item property) {
		return new CustomAbstractPropertyEditor<AnchorPoint, TextField>(property, new TextField()) {
			{
				getEditor().setEditable(false);
				setReadOnly(true);
			}

			/**
		     * Returns the current value in the editor - this may not be the value of
		     * the property itself!
		     */
			@Override
			public AnchorPoint getValue() {
				return (AnchorPoint) property.getValue();
			}

			/**
		     * Sets the value to display in the editor - this may not be the value of 
		     * the property itself - and the property value will not change!
		     */
			@Override
			public void setValue(AnchorPoint value) {
				getEditor().setText(value == null ? "Not connected" : value.toString()); //$NON-NLS-1$
			}

			@SuppressWarnings("unchecked")
			@Override
			protected ObservableValue<AnchorPoint> getObservableValue() {
				return (ObservableValue<AnchorPoint>) (Object) getEditor().textProperty();
			}
		};
	}

	/**
	 * Enable input for Enter button
	 * @param control
	 */
	private static void enableEnter(final TextInputControl control) {
		control.setOnKeyPressed(event -> {

			if (KeyCode.ENTER == event.getCode()) {
				control.getParent().requestFocus();
			}
		});
	}
	
	/**
	 * Enable auto select of all text when the control takes focus.
	 * @param control
	 */
	private static void enableAutoSelectAll(final TextInputControl control) {
        control.focusedProperty().addListener((ObservableValue<? extends Boolean> o, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                Platform.runLater(() -> {
                    control.selectAll();
                });
            }
        });
    }
	
	private static void disableJavaFXUndoManager(final TextInputControl control) {
		control.addEventFilter(KeyEvent.ANY, e -> {
            if ((e.getCode() == KeyCode.Z || e.getCode() == KeyCode.Y) && e.isShortcutDown()) {
            	control.getParent().fireEvent(e);
            }
        });
	}

}