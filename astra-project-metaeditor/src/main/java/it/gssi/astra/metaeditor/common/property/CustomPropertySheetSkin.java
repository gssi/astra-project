package it.gssi.astra.metaeditor.common.property;

import static impl.org.controlsfx.i18n.Localization.asKey;
import static impl.org.controlsfx.i18n.Localization.localize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SkinBase;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.control.PropertySheet.Mode;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionUtils;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.property.editor.AbstractPropertyEditor;
import org.controlsfx.property.editor.PropertyEditor;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.decoration.CompoundValidationDecoration;
import org.controlsfx.validation.decoration.StyleClassValidationDecoration;
import org.controlsfx.validation.decoration.ValidationDecoration;
import org.eclipse.core.databinding.Binding;

import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.dataManager.databinding.DataBinding;
import it.gssi.astra.metaeditor.common.property.NumericField.NumericValidator;
import it.gssi.astra.metaeditor.common.property.customInterface.ICustomItem;
import it.gssi.astra.metaeditor.common.property.validation.CustomGraphicValidationDecoration;

/**
 * This class has been edited to customize the layout of property view adding separator labels by category
 * and the name of selected element inside the tab.
 *
 */
public class CustomPropertySheetSkin extends SkinBase<PropertySheet> {
    
    /**************************************************************************
     * 
     * Static fields
     * 
     **************************************************************************/

    private static final int MIN_COLUMN_WIDTH = 100;
    
    /**************************************************************************
     * 
     * fields
     * 
     **************************************************************************/
    
    private final BorderPane content;
    private final ScrollPane scroller;
    private final ToolBar toolbar;
    private final SegmentedButton modeButton = ActionUtils.createSegmentedButton(
        new ActionChangeMode(Mode.NAME),
        new ActionChangeMode(Mode.CATEGORY)
    );
    private final TextField searchField = TextFields.createClearableTextField();
    
    private Tab tab1;
    
    private static CustomPropertySheetSkin instance;
    
    public static CustomPropertySheetSkin getInstance() {
    	return instance;
    }
    
    
    /**************************************************************************
     * 
     * Constructors
     * 
     **************************************************************************/

    public CustomPropertySheetSkin(final PropertySheet control) {
        super(control);
        
        TabPane tabPane = new TabPane();

        tab1 = new Tab("Properties", new Label("Show all properties"));
        
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        tabPane.minWidth(400);
        tabPane.prefWidth(400);
        scroller = new ScrollPane();
        scroller.setFitToWidth(true);
        
        toolbar = new ToolBar();
        toolbar.managedProperty().bind(toolbar.visibleProperty());
        toolbar.setFocusTraversable(true);
        
        // enable buttons to change property sheet mode - by NAME or CATEGORY
//        modeButton.managedProperty().bind(modeButton.visibleProperty());
//        modeButton.getButtons().get(getSkinnable().modeProperty().get().ordinal()).setSelected(true);
//        toolbar.getItems().add(modeButton);
        
        // property sheet search
        searchField.setPromptText( localize(asKey("property.sheet.search.field.prompt"))); //$NON-NLS-1$
        searchField.setMinWidth(0);
        HBox.setHgrow(searchField, Priority.SOMETIMES);
        searchField.managedProperty().bind(searchField.visibleProperty());
        toolbar.getItems().add(searchField);
        
        // layout controls
        content = new BorderPane();
        content.setTop(toolbar);
        
        tab1.setContent(scroller);

        tabPane.getTabs().add(tab1);
        content.setCenter(tabPane);
        getChildren().add(content);
              
        
        // setup listeners
        registerChangeListener(control.modeProperty(), e -> refreshProperties());
        registerChangeListener(control.propertyEditorFactory(), e -> refreshProperties());
        registerChangeListener(control.titleFilter(), e -> refreshProperties());
        registerChangeListener(searchField.textProperty(), e -> getSkinnable().setTitleFilter(searchField.getText()));
        registerChangeListener(control.modeSwitcherVisibleProperty(), e -> updateToolbar());
        registerChangeListener(control.searchBoxVisibleProperty(), e -> updateToolbar());
        registerChangeListener(control.categoryComparatorProperty(), e -> refreshProperties());
        
        control.getItems().addListener((ListChangeListener<Item>) change -> refreshProperties());
        
        // initialize properly 
        refreshProperties(); 
        updateToolbar();
        
        instance = this;
    }


    /**************************************************************************
     * 
     * Overriding public API
     * 
     **************************************************************************/

    @Override protected void layoutChildren(double x, double y, double w, double h) {
        content.resizeRelocate(x, y, w, h);
    }



    /**************************************************************************
     * 
     * Implementation
     * 
     **************************************************************************/
    
    private void updateToolbar() {
        modeButton.setVisible(getSkinnable().isModeSwitcherVisible());
        searchField.setVisible(getSkinnable().isSearchBoxVisible());
        
        toolbar.setVisible(modeButton.isVisible() || searchField.isVisible());
    }

    private void refreshProperties() {
    	
    	// Dispose old bindings in order to remove listeners from the models
	    List<Binding> bindings = new ArrayList<Binding>(DataBinding.getInstance().getPropertyViewContext().getBindings());
	
		for (Binding b : bindings) {
			b.dispose();
		}
		
    	//tab1.setText("Properties" + (SelectionModel.size() == 1 ? " : " + SelectionModel.get().iterator().next().getEnte().className : ""));
        scroller.setContent(buildPropertySheetContainer());
    }
    
    /**
     * Set the name of the selected {@code DraggableNode} inside the tab of property view. 
     * @param text The name of the meta-class
     */
    public void setTab1(String text) {
    	String result = "Properties";
    	
    	if (text != null && !text.isEmpty())
    		result += " : " + text;
    
    	tab1.setText(result);
    }
    
    /**
     * This method uses {@link CustomPropertyItem#getCategory()}
     */
    private Node buildPropertySheetContainer() {
        switch( getSkinnable().modeProperty().get() ) {
            case CATEGORY: {
                // group by category
                Map<String, List<Item>> categoryMap = new TreeMap<String, List<Item>>(getSkinnable().getCategoryComparator());
                for( Item p: getSkinnable().getItems()) {
                    String category = p.getCategory();
                    List<Item> list = categoryMap.get(category);
                    if ( list == null ) {
                        list = new ArrayList<>();
                        categoryMap.put( category, list);
                    }
                    list.add(p);
                }
                
                //Add header - category name - to each group of properties
            	VBox vbox = new VBox();
            	
                for( String category: categoryMap.keySet() ) {
                	PropertyPane props = new PropertyPane( categoryMap.get(category));
                	// Only show non-empty categories 
                	if ( props.getChildrenUnmodifiable().size() > 0 ) {
                		
                		Label textCategory = new Label(category);
                    	textCategory.setStyle("-fx-font-weight: bold");
                    	textCategory.setTextFill(Color.GRAY);
                    	textCategory.setPadding(new Insets(10, 0, 2, 15));
                    	
                    	Separator separator = new Separator();
                    	separator.setPadding(new Insets(0, 15, 2, 15));
                    	
                    	vbox.getChildren().addAll(textCategory, separator, props);
                    	
                    }
                }

                return vbox;
            }
            
            default: return new PropertyPane(getSkinnable().getItems());
        }
        
    }

    
    /**************************************************************************
     * 
     * Support classes / enums
     * 
     **************************************************************************/
    
    private class ActionChangeMode extends Action {
        
    	private final Image CATEGORY_IMAGE = new Image(CustomPropertySheetSkin.class.getResource("/org/controlsfx/control/format-indent-more.png").toExternalForm()); //$NON-NLS-1$
    	private final Image NAME_IMAGE = new Image(CustomPropertySheetSkin.class.getResource("/org/controlsfx/control/format-line-spacing-triple.png").toExternalForm()); //$NON-NLS-1$
    	
        public ActionChangeMode(PropertySheet.Mode mode) {
            super(""); //$NON-NLS-1$
            setEventHandler(ae -> getSkinnable().modeProperty().set(mode));
            
            if (mode == Mode.CATEGORY) {
                setGraphic( new ImageView(CATEGORY_IMAGE));
                setLongText(localize(asKey("property.sheet.group.mode.bycategory"))); //$NON-NLS-1$
            } else if (mode == Mode.NAME) {
                setGraphic(new ImageView(NAME_IMAGE));
                setLongText(localize(asKey("property.sheet.group.mode.byname"))); //$NON-NLS-1$
            } else {
                setText("???"); //$NON-NLS-1$
            }
        }

    }
    
    
    private class PropertyPane extends GridPane {
        
        public PropertyPane( List<Item> properties ) {
            this( properties, 0 );
        }
        
        public PropertyPane( List<Item> properties, int nestingLevel ) {
            setVgap(5);
            setHgap(5);
            setPadding(new Insets(5, 15, 5, 15 + nestingLevel*10 ));
            getStyleClass().add("property-pane"); //$NON-NLS-1$
            setItems(properties);
//            setGridLinesVisible(true);
        }
        
        public void setItems( List<Item> properties ) {
            getChildren().clear();
            
            String filter = getSkinnable().titleFilter().get();
            filter = filter == null? "": filter.trim().toLowerCase(); //$NON-NLS-1$

            int row = 0;
            
            for (Item item : properties) {

                // filter properties
                String title = item.getName();
               
                if ( !filter.isEmpty() && title.toLowerCase().indexOf( filter ) < 0) continue;
                
                // setup property label
                Label label = new Label(title);
                Tooltip tooltip = new Tooltip(title);
    			Tooltip.install(label, tooltip);
                label.setMinWidth(MIN_COLUMN_WIDTH);
                
                // show description as a tooltip
                String description = item.getDescription();
                if ( description != null && !description.trim().isEmpty()) {
                    label.setTooltip(new Tooltip(description));
                }
                
                add(label, 0, row);

                // setup property editor
                Node editor = getEditor(item);
                
                if (editor instanceof Region) {
                    ((Region)editor).setMinWidth(MIN_COLUMN_WIDTH);
                    ((Region)editor).setMaxWidth(Double.MAX_VALUE);
                }
                label.setLabelFor(editor);
                add(editor, 1, row);

                // Add reset button for items that support reset to default value
                if (!(item instanceof UnbackedCustomPropertyItem)) {
                	Button resetButton = new Button();
    				resetButton.setMinWidth(25);

    				Image m = new Image(LayoutScene.class.getResource("/common/img/clear.png").toExternalForm());
    				ImageView u = new ImageView(m);
    				u.setFitHeight(15);
    				u.setFitWidth(15);
    				resetButton.setGraphic(u);
    				resetButton.setOpacity(0);
    				
    				resetButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							resetButton.setOpacity(1);
						}
    				
    				});
    				
    				resetButton.setOnMouseExited(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent event) {
							resetButton.setOpacity(0);
						}
    				
    				});

    				ICustomItem myItem = (ICustomItem) item;
    				resetButton.visibleProperty().bind(myItem.editableProperty());

    				resetButton.setOnAction(new EventHandler<ActionEvent>() {
    					@Override
    					public void handle(ActionEvent e) {
    						myItem.reset();
    					}
    				});

    				add(resetButton, 2, row);
                }
				
				GridPane.setHgrow(editor, Priority.ALWAYS);

				row++;
            }
            
        }
        
        @SuppressWarnings("unchecked")
        private Node getEditor(Item item) {
            @SuppressWarnings("rawtypes")
			PropertyEditor editor = getSkinnable().getPropertyEditorFactory().call(item);
            if (editor == null) {
                editor = new AbstractPropertyEditor<Object, TextField>(item, new TextField(), true) {
                    {
                        getEditor().setEditable(false);
                        getEditor().setDisable(true);
                    }
                    
                    /**
                     * {@inheritDoc}
                     */
                    @Override protected ObservableValue<Object> getObservableValue() {
                        return (ObservableValue<Object>)(Object)getEditor().textProperty();
                    }
                    
                    /**
                     * {@inheritDoc}
                     */
                    @Override public void setValue(Object value) {
                        getEditor().setText(value == null? "": value.toString()); //$NON-NLS-1$
                    }
                };
            } else if (! item.isEditable()) {
            	if (editor instanceof CustomAbstractPropertyEditor)
            		((CustomAbstractPropertyEditor<Object, ?>)editor).setReadOnly(true);
            	else
            		editor.getEditor().setDisable(true);
            }
            if (!(item instanceof BackedCustomPropertyItem)) {
            	editor.setValue(item.getValue());
            }

            ICustomItem myItem = (ICustomItem) item;

            ValidationSupport validationSupport = new ValidationSupport();
			
			if (myItem.getValidator().isPresent()) {
				
				ValidationDecoration iconDecorator = new CustomGraphicValidationDecoration();
				ValidationDecoration cssDecorator = new StyleClassValidationDecoration();
				ValidationDecoration compoundDecorator = new CompoundValidationDecoration(cssDecorator, iconDecorator);
				validationSupport.setValidationDecorator(compoundDecorator);
				
				validationSupport.registerValidator((Control) editor.getEditor(), myItem.getValidator().get());

				PropertyEditor<Object> temp = editor;
				validationSupport.invalidProperty().addListener((obs, wasInvalid, isNowInvalid) -> {
					if (isNowInvalid) {
						if (temp.getEditor() instanceof NumericField)
							disableEnter((NumericField) temp.getEditor());
					} else {
						if (temp.getEditor() instanceof NumericField)
							enableEnter((NumericField) temp.getEditor());
					}
				});
			}
			
			ValidationSupport.setRequired((Control) editor.getEditor(), myItem.isRequired());
            
            return editor.getEditor();
        }
        
        private void disableEnter(NumericField control) {
    		control.setOnKeyPressed(event -> {

    			if (KeyCode.ENTER == event.getCode()) {
    				event.consume();
    			}
    		});
    	}
        
        private void enableEnter(NumericField control) {
    		control.setOnKeyPressed(event -> {

    			if (KeyCode.ENTER == event.getCode()) {
    				@SuppressWarnings("unchecked")
					NumericValidator<? extends Number> value = (NumericValidator<? extends Number>) control.valueProperty();
    				value.setValue(value.toNumber(control.getText()));
    				control.getParent().requestFocus();
    			}
    		});
    	}
    }
}