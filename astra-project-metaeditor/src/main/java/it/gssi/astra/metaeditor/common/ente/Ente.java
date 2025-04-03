package it.gssi.astra.metaeditor.common.ente;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.property.BeanProperty;
import org.controlsfx.validation.Validator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;

import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.RotationPosition;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.CanvasManagementImpl;
import it.gssi.astra.metaeditor.common.canvas.SelectionModel;
import it.gssi.astra.metaeditor.common.dataManager.databinding.DataBinding;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.grid.GridUtils;
import it.gssi.astra.metaeditor.common.magnete.AnchorPoint;
import it.gssi.astra.metaeditor.common.magnete.AnchorPointVirtual;
import it.gssi.astra.metaeditor.common.property.BackedCustomPropertyItem;
import it.gssi.astra.metaeditor.common.property.CustomPropertyEditorFactory;
import it.gssi.astra.metaeditor.common.property.CustomPropertySheetSkin;
import it.gssi.astra.metaeditor.common.property.PropertyViewUtils;
import it.gssi.astra.metaeditor.common.property.UnbackedCustomPropertyItem;
import it.gssi.astra.metaeditor.common.property.customPropertyEditors.RotationPropertyEditor;
import it.gssi.astra.metaeditor.common.property.impl.CustomBeanProperty;
import it.gssi.astra.metaeditor.common.treeView.CategoryTreeItem;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeItem;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import it.gssi.astra.metaeditor.common.utility.FXMLeAttribute;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 * 
 * This class represent the base controller of graphics domain node contains the
 * view {@link FXML} and model {@link EObject} each graphical element has a
 * corresponding controller which extends the base controller
 * 
 */
public class Ente extends Group {

	@FXML
	protected Group root;

	@FXML
	public Pivot pivot;

	public ElementPosition elementPosition;
	
	public GraphicalElement graphicalElement;

	protected FXMLLoader fxmlLoader;

	public ObservableList<Item> properties = FXCollections.observableArrayList();
	
	public BackedCustomPropertyItem magnetizable;

	public CustomBeanProperty layoutX_propertyItem, layoutY_propertyItem;

	public EnteContextMenu contextMenu;

	public CustomTreeItem treeItem;

	public CustomTreeItem getTreeItem() {
		return treeItem;
	}

	public void setTreeItem(CustomTreeItem treeItem) {
		this.treeItem = treeItem;
	}

	public StringProperty identifier = new SimpleStringProperty();

	public StringProperty identifierProperty() {
		return identifier;
	}

	public String getIdentifier() {
		return identifier.getValue();
	}

	/**
	 * @param identifier is the identifier of this ente {@link TreeView}
	 *                   {@link GraphicalElement#getNameAttribute()}
	 */
	public void setIdentifier(String identifier) {
		if (identifier != null)
			this.identifier.setValue(identifier);
		else 
			this.identifier.setValue(new String(""));
	}
	
	public Ente() {}

	/**
	 * @param name represent the identifier of this ente
	 *
	 */
	public Ente(String name) {
		this.setIdentifier(name);
	}

	/**
	 * this method not return EObject because scene builder not support EMF
	 * 
	 * @return EObject
	 */
	public EObject getModel() {
		return null;
	}

	/**
	 * Initializes the listener of notifications coming from domain model consisting
	 * of ADD and REMOVE of children and changes to StructuralFeatures. Initializes
	 * the binding between {@code Ente#visibilityProperty} and
	 * {@code Ente#pinnedProperty} with the persistence model.
	 */
	public void initialization() {

		contextMenu = new EnteContextMenu(this);
		/**
		 * If not initialized create Pivot but after parsing FXML place holders to
		 * Top-Left
		 * 
		 */
		if (pivot == null) {
			pivot = new Pivot(this);
		}
		
		magnetizable = new BackedCustomPropertyItem(elementPosition, "AnchorPoints", "magnetizable", true);

		// put in the ViewModelMap the link between the domain model and this ente
		LayoutScene.getViewModelMap().put(getModel(), this);

		EObject model = (EObject) getModel();

		// binding between eStuctural Features and fxml attributes
		ecoreAttributes = FXMLUtil.addChangeHandler(model, fxmlLoader);

		// listener that notify changed model and call the specific method into domain
		// fx classes
		model.eAdapters().add(new AdapterImpl() {
			public void notifyChanged(Notification notification) {
			if (notification.getEventType() != Notification.REMOVING_ADAPTER) {	
				if ((notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.SET)
						&& ((EStructuralFeatureImpl) notification.getFeature()).isContainment()) {
					// Case of children removing
					if (notification.getNewValue() == null) {

						EObject source = (EObject) notification.getOldValue();

						Ente e = LayoutScene.getViewModelMap().get(source);
						
						// Clear the adapters to avoid duplication with CTRL-Y
						e.getModel().eAdapters().clear();
						e.elementPosition.eAdapters().clear();

						LayoutScene.getInstance().propertySheet.getItems().clear();

						// Remove node from this map before canvas
						LayoutScene.getViewModelMap().inverse().remove(e);
						LayoutScene.getInstance().getCanvas().getChildren().remove(e.getDraggableNode());

						Ente padreFX = LayoutScene.getViewModelMap().get(notification.getNotifier());
						padreFX.getDraggableNode().selectedProperty()
								.removeListener(e.getDraggableNode().selectWithParentListener);

						Platform.runLater(() -> {
							if (e.treeItem.getParent() != null) {
								e.treeItem.getParent().getChildren().remove(e.treeItem);
							}
							if (padreFX != null && padreFX.getModel().eResource() != null && padreFX.getDraggableNode() != null) {
								SelectionModel.add(padreFX.getDraggableNode());
							}
							/*else 
								SelectionModel.clear(true);*/
						});

					}
				}
				
				if (notification.getFeature() instanceof EStructuralFeatureImpl &&
						notification.getNewValue() != notification.getOldValue()) {
					
					String changedField = ((EStructuralFeatureImpl) notification.getFeature()).getName();
					String methodName = "on" + changedField.substring(0, 1).toUpperCase()
							+ changedField.substring(1) + "Changed";

					try {
						Method method = Ente.this.getClass().getMethod(methodName, Object.class);
						method.invoke(Ente.this, notification.getNewValue());
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}

					// Breaks the undo of TextField
//					DataBinding.getInstance().getPropertyViewContext().updateTargets();
					DataBinding.getInstance().getAnchorPointsContext().updateTargets();
				}

				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.SET) {

					if (notification.getOldValue() == null) {
						if (notification.getFeature() instanceof EReference) {

							EReference domainRef = (EReference) notification.getFeature();

							if (domainRef.isContainment()) {
								CanvasManagementImpl.getInstance().addElement((EObject) notification.getNewValue(),
										(EObject) notification.getNotifier(), domainRef);

								Ente e = LayoutScene.getViewModelMap().get((EObject) notification.getNewValue());
								e.synchronizeAnchorPoints();
							}
						}
					}
				}
				
				// Trigger front-end update for lists
				if ( ((EStructuralFeatureImpl) notification.getFeature()).getUpperBound() != 1) {
					BackedCustomPropertyItem item = LayoutScene.findPropertyField(((EStructuralFeatureImpl) notification.getFeature()).getName());
					
					// Some feature could not have a property item (e.g. containments)
					if (item != null)
						// Check if the item is currently showed in the property view
						if (!item.getBinding().isDisposed())
							item.getBinding().updateModelToTarget();
				}
			}
			}
		});

		JFX2EMF.bindValues(Contexts.PERSISTENCE, elementPosition, "visible", this, "visibility",
				Converters.NONE);
		JFX2EMF.bindValues(Contexts.PERSISTENCE, elementPosition, "pinned", this, "pinned",
				Converters.NONE);

		initializePlaceholders(model);
	}
	
	/**
	 * Must be called after the initialization.
	 * Initializes the binding between {@code Ente#rotationProperty} with the persistence model.
	 * 
	 */
	public void postInit() {
		if (this.allowedRotationPositions.size() > 0) {
			JFX2EMF.bindValues(Contexts.PERSISTENCE, elementPosition, "rotationPosition", this, "rotation",
					Converters.TRY_RECONNECTION);
		}
	}

	/**
	 * Allows to customize the context menu in each subclasses
	 */
	public void createMenu() {

	}

	public DraggableNode getDraggableNode() {
		return (DraggableNode) this.getParent();
	}

	/**
	 * Get the default value for snap to grid step resolution. This methods can be
	 * overridden by subclasses in order to customize the behavior of
	 * {@link DraggableNode#snapToGrid(Pivot)}.
	 * 
	 * @return an int value
	 */
	public int getDraggingStepLength() {
		return GridUtils.DRAGGING_STEP_LENGTH;
	}

	/**
	 * Update property with default field
	 */
	public void populatePropertyView() {

		properties.clear();
		

		layoutX_propertyItem = PropertyViewUtils.createPropertyField(getDraggableNode(), "layoutX", "X", "Basic",
				"The value of X coordinate", true, 0.0);
		
		if (layoutX_propertyItem != null) {
			Validator<Object> validator = Validator.createPredicateValidator((val) -> getDraggableNode().isXInsideCanvas(val), "Value out of canvas");
			layoutX_propertyItem.setValidator(validator);
			properties.add(layoutX_propertyItem);
		}

		layoutY_propertyItem = PropertyViewUtils.createPropertyField(getDraggableNode(), "layoutY", "Y", "Basic",
				"The value of Y coordinate", true, 0.0);
		
		if (layoutY_propertyItem != null){
			Validator<Object> validator = Validator.createPredicateValidator((val) -> getDraggableNode().isYInsideCanvas(val), "Value out of canvas");
			layoutY_propertyItem.setValidator(validator);
			properties.add(layoutY_propertyItem);
		}
		
		BeanProperty viewOrder_propertyItem = PropertyViewUtils.createPropertyField(getDraggableNode(), "viewOrder", "Z-index", "Basic",
				"The value of view order", true, this.graphicalElement.getZIndexDefault());
		properties.add(viewOrder_propertyItem);

		BeanProperty pinned_propertyItem = PropertyViewUtils.createPropertyField(this, "pinned", "Pinned", "Basic",
				"Toggle drag ability", true, false);
		properties.add(pinned_propertyItem);

		// Check again pinned property because coordinate property fields were not yet
		// assigned at initialization.
		if (getPinned()) {
			layoutX_propertyItem.setEditable(false);
			layoutY_propertyItem.setEditable(false);
		} else {
			layoutX_propertyItem.setEditable(true);
			layoutY_propertyItem.setEditable(true);
		}

		UnbackedCustomPropertyItem visible_Pivot = new UnbackedCustomPropertyItem(((val) -> pivot.setVisible((boolean) val)),
				"Basic#Visible Pivot", pivot.isVisible(), true);
		properties.add(visible_Pivot);

		BeanProperty visibility_propertyItem = PropertyViewUtils.createPropertyField(this, "visibility", "Visible",
				"Basic", "Toggle the visibility", true, true);
		properties.add(visibility_propertyItem);
		
		if (allowedRotationPositions.size() > 0) {
			BeanProperty rotationPosition_propertyItem = PropertyViewUtils.createPropertyField(this, "rotation", "Rotation", "Basic",
					"Toggle drag ability", true, RotationPosition.DEFAULT);
			rotationPosition_propertyItem.getPropertyDescriptor().setPropertyEditorClass(RotationPropertyEditor.class);
			properties.add(rotationPosition_propertyItem);
		}

		// Update tab name
		//CustomPropertySheetSkin.getInstance().setTab1(getMetaClassName());
		CustomPropertySheetSkin.getInstance().setTab1(this.graphicalElement.getElement().getName());
	}

	/*************************************************************************
	 * * Properties - START
	 *************************************************************************/

	/**
	 * Specifies whether this {@code Ente} and any children should be visible on the
	 * Canvas. It calls {@link javafx.scene.Node#setVisible(boolean)} on the
	 * {@code DraggableNode} so it will not be rendered nor it will receive mouse
	 * events.
	 *
	 * @defaultValue true
	 */
	protected BooleanProperty visibilityProperty;

	public boolean getVisibility() {
		return visibilityProperty.get();
	}

	public void setVisibility(boolean value) {

		boolean oldValue = visibilityProperty().get();
		visibilityProperty().set(value);

		if (!(value == true && oldValue == true)) {
			EList<EObject> children = elementPosition.getElement().eContents();
			for (EObject eObject : children) {
				Ente element = LayoutScene.getViewModelMap().get(eObject);
				if (element != null) {
					element.elementPosition.setVisible(value);
					if (element.getTreeItem() != null) {
						element.getTreeItem().checkBox.setSelected(value);
					}
				}
			}
			
			//aggiorno la checkbox del parent
			if(Ente.this.getTreeItem() != null && Ente.this.getTreeItem().getParent() instanceof CategoryTreeItem) {
				CategoryTreeItem parent = (CategoryTreeItem) Ente.this.getTreeItem().getParent();
				for (TreeItem<String> treeItem : parent.getChildren()) {
					if(treeItem instanceof CustomTreeItem) {
						CustomTreeItem treeItemC  = (CustomTreeItem) treeItem;
						
						if (!treeItemC.checkBox.isSelected()) {
							parent.checkBox.setSelected(false);
							return;
						}
					}
				}
				parent.checkBox.setSelected(true);
			}
		}
	}
	
	public void setVisibilityNoParent(boolean value) {
		
		boolean oldValue = visibilityProperty().get();
		visibilityProperty().set(value);

		if (!(value == true && oldValue == true)) {
			EList<EObject> children = elementPosition.getElement().eContents();
			for (EObject eObject : children) {
				Ente element = LayoutScene.getViewModelMap().get(eObject);
				if (element != null) {
					element.elementPosition.setVisible(value);
					if (element.getTreeItem() != null) {
						element.getTreeItem().checkBox.setSelected(value);
					}
				}
			}
		}
	}

	public BooleanProperty visibilityProperty() {
		if (visibilityProperty == null) {
			visibilityProperty = new BooleanPropertyBase(true) {
				@Override
				protected void invalidated() {

					Ente.this.getDraggableNode().setVisible(get());

					if (Ente.this.getTreeItem() != null) {
						Ente.this.getTreeItem().checkBox.setSelected(get());
					}
				}

				@Override
				public Object getBean() {
					return Ente.this;
				}

				@Override
				public String getName() {
					return "visibility";
				}
			};
		}
		return visibilityProperty;
	}

	/**
	 * Specifies whether this {@code Ente} (but not its children) should be pinned
	 * on the Canvas. The properties fields for coordinate editing will be disabled.
	 * The code in Platform.runLater is not executed at initialization, so it is
	 * repeated at {@link populatePropertyView()}.
	 *
	 * @defaultValue false
	 */
	protected BooleanProperty pinnedProperty;

	public boolean getPinned() {
		return pinnedProperty.get();
	}

	public void setPinned(boolean value) {
		pinnedProperty().set(value);
	}

	public BooleanProperty pinnedProperty() {
		if (pinnedProperty == null) {
			pinnedProperty = new BooleanPropertyBase(false) {
				@Override
				protected void invalidated() {

					Platform.runLater(() -> {
						if (layoutX_propertyItem != null && layoutY_propertyItem != null) {
							if (get()) {
								layoutX_propertyItem.setEditable(false);
								((CustomPropertyEditorFactory) LayoutScene.getInstance().propertySheet
										.getPropertyEditorFactory()).getEditors().get(layoutX_propertyItem)
												.setDisable(true);
								layoutY_propertyItem.setEditable(false);
								((CustomPropertyEditorFactory) LayoutScene.getInstance().propertySheet
										.getPropertyEditorFactory()).getEditors().get(layoutY_propertyItem)
												.setDisable(true);
							} else {
								layoutX_propertyItem.setEditable(true);
								((CustomPropertyEditorFactory) LayoutScene.getInstance().propertySheet
										.getPropertyEditorFactory()).getEditors().get(layoutX_propertyItem)
												.setDisable(false);
								layoutY_propertyItem.setEditable(true);
								((CustomPropertyEditorFactory) LayoutScene.getInstance().propertySheet
										.getPropertyEditorFactory()).getEditors().get(layoutY_propertyItem)
												.setDisable(false);
							}
						}
					});
				}

				@Override
				public Object getBean() {
					return Ente.this;
				}

				@Override
				public String getName() {
					return "pinned";
				}
			};
		}
		return pinnedProperty;
	}
	

	/**
	 * Specifies the rotate value of the node. It calls
	 * {@link javafx.scene.Node#setRotate(double)} on the {@code DraggableNode} to
	 * rotate the node. The variable {@link Ente#allowedRotationPositions} should be
	 * populated by subclasses of {@code Ente} with objects of type
	 * {@link RotationPosition}. If it is not populated there will be no field in
	 * the property view to change the rotation
	 *
	 * @defaultValue RotationPosition.DEFAULT
	 */
	protected ObjectProperty<Object> rotationProperty;

	public List<RotationPosition> allowedRotationPositions = new ArrayList<>();
	
	public Object getRotation() {
		return rotationProperty.get();
	}

	public void setRotation(Object value) {
		rotationProperty().set(value);
	}

	public ObjectProperty<Object> rotationProperty() {
		if (rotationProperty == null) {
			rotationProperty = new SimpleObjectProperty<Object>(RotationPosition.DEFAULT) {
				@Override
				protected void invalidated() {
					
					DraggableNode dnode = Ente.this.getDraggableNode();
					
					// vecchio metodo che sta su develop che non aggiorna le coordinate che quindi sono disallineate
					// rispetto a quanto mostrato nella property view
//					dnode.setRotate(((RotationPosition) get()).getValue());

					// nuovo metodo che ruota l'oggetto forzandolo a rimanere nelle coordinate mostrate nella property view
					
					// elimino qualsiasi trasformazione precedente
					Ente.this.getTransforms().clear();
					// eliminare qualsiasi trasformazione hard-codata nell'fxml che con la clear non vengono eliminate
					// (ad esempio FabbricatoViaaggiatori.fxml ha uno scaleX="-1.0" che da qui non posso eliminare)
					
					double angle = ((RotationPosition) get()).getValue();	            
					
					// Una rotazione con una angolo qualsiasi e intorno al centro dell'oggetto
					Rotate rotate = new Rotate();
		            rotate.setAngle(angle);
		            rotate.setPivotX(dnode.getBoundsInLocal().getCenterX());
		            rotate.setPivotY(dnode.getBoundsInLocal().getCenterY());
		            // Non viene mai applicata, ma la sfrutto per fare una custom_rotate
		            // dove azzero i campi Tx e Ty della matrice di trasformazione
		            
		            Affine custom_rotate;
		            
		            // Customization of the rotation creating a new affine trasformation (passing Tx = 0 and Ty = 0 as parameters means rotating around the origin)
		            custom_rotate = Affine.affine(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), rotate.getMyy(), 0, 0);
		            
//		            System.out.println("transformation matrix: " + dnode.getLocalToParentTransform());
//		            System.out.println("transformation matrix ente: " + Ente.this.getLocalToParentTransform());
		            
		            // Applico la custom_rotate
		            Ente.this.getTransforms().add(custom_rotate);
		            
//		            System.out.println("transformation matrix ente: " + Ente.this.getLocalToParentTransform());
		            
		            // I campi Tx e Ty non sono gli unici spostamenti che javaFX applica all'oggetto (anche i campi Mxx, Myx, Mxy, Myy hanno un effetto)
		            // quindi recupero qualsiasi spostamento applicate da javaFX localmente all'oggetto
		            // in questo modo
		            Bounds h = Ente.this.getBoundsInParent();
		            double Tx = h.getMinX();
		            double Ty = h.getMinY();
		            
		            // Annullo anche questo spostamento con una nuova trasformazione cosi da riportare l'oggeto nelle coordinate originali
		            // corrispondenti a quelle mostrate nella property view
		            Affine a = Affine.affine(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), rotate.getMyy(), 0 - Tx, 0 - Ty);
		            
		            // Elimino la vecchia trasformazione
		            Ente.this.getTransforms().clear();
		            // Inserisco la nuova appena creata
		            Ente.this.getTransforms().add(a);
		            
//		            System.out.println("transformation matrix: " + dnode.getLocalToParentTransform());
//		            System.out.println("transformation matrix ente: " + Ente.this.getLocalToParentTransform());
		            
		            // calcolo di quanto si deve spostare tutto il draggable node affinché l'ente sia allineato alla griglia
		            double[] offset = GridUtils.snapToGrid(pivot.getCoordinatesRelativeToCanvas(), Ente.this.getDraggingStepLength());
		            
		            // calcolo la nuova posizione che si avrebbe (che per i 45 gradi potrebbe essere con la virgola)
		            double new_X = Ente.this.getDraggableNode().getLayoutX() + offset[0];
		            double new_Y = Ente.this.getDraggableNode().getLayoutY() + offset[1];
//		            System.out.println("new_X: " + new_X);
//		            System.out.println("new_Y: " + new_Y);
		            
		            // approsimo per difetto
		            double new_X_floored = Math.floor(new_X);
		            double new_Y_floored = Math.floor(new_Y);
//		            System.out.println("new_X_floored: " + new_X_floored);
//		            System.out.println("new_Y_floored: " + new_Y_floored);
		            
		            // conversione a interi
		            int new_X_intero = (int) new_X_floored;
		            int new_Y_intero = (int) new_Y_floored;
		            
		            // calcolo dimensione cuscinetto da applicare al pittogramma in modo da mantenere l'allineamento alla griglia
		            double cuscinetto_X = new_X - new_X_floored;
		            double cuscinetto_Y = new_Y - new_Y_floored;
//		            System.out.println("cuscinetto_X: " + cuscinetto_X);
//		            System.out.println("cuscinetto_Y: " + cuscinetto_Y);
		            
		            // aggiorno la posizione del draggable node (il pittogramma viene in questo modo disallineato)
		            Ente.this.getDraggableNode().setLayoutX(new_X_intero);
		            Ente.this.getDraggableNode().setLayoutY(new_Y_intero);
		            
		            // applico il cuscinetto al pittogramma e riottengo l'allineamento
		            Ente.this.setLayoutX(Ente.this.getLayoutX() + cuscinetto_X);
		            Ente.this.setLayoutY(Ente.this.getLayoutY() + cuscinetto_Y);
		            
		            
		            
		            // this a method to rotate around the center of the object updating correctly the coordinates too
		            // but should be tested further
		            
//		            double old_layoutX = dnode.getLayoutX();
//		            double old_layoutY = dnode.getLayoutY();
//		            
//		            double center_X = old_layoutX + dnode.getBoundsInLocal().getCenterX();
//		            double center_Y = old_layoutY + dnode.getBoundsInLocal().getCenterY();
//		            
//		            double new_layoutX = (old_layoutX - center_X)*Math.cos(Math.toRadians(angle)) - (center_Y - old_layoutY)*Math.sin(Math.toRadians(angle)) + center_X;
//		            double new_layoutY = (old_layoutX - center_X)*Math.sin(Math.toRadians(angle)) + (center_Y - old_layoutY)*Math.cos(Math.toRadians(angle)) + center_Y;
//		            
//		            if (new_layoutX > 0)
//		            	dnode.setLayoutX(new_layoutX);
//		            
//		            if (new_layoutY > 0)
//		            	dnode.setLayoutY(new_layoutY);
//		            
//					System.out.println("transformation matrix: " + dnode.getLocalToParentTransform());
		            
		             
					for (Node text : Ente.this.lookupAll("Label")) {
						text.setRotate(((RotationPosition) get()).getValue());
					}
					
				}

				@Override
				public Object getBean() {
					return Ente.this;
				}

				@Override
				public String getName() {
					return "rotation";
				}
			};
		}
		return rotationProperty;
	}

	/*************************************************************************
	 * * Properties - END
	 *************************************************************************/

	/*************************************************************************
	 * * AnchorPoint helpers - START
	 *************************************************************************/

	public List<AnchorPoint> getAnchorPoints() {
		return Collections.emptyList();
	}

	public Map<AnchorPoint, List<AnchorPoint>> getTargetAnchorPointsSet() {
		return Collections.emptyMap();
	}

	public AnchorPoint getAnchorPointByTarget(Ente ente) {
		return null;
	}

	/**
	 * Binding between the target value of the anchor points to the value of their
	 * associated reference. To be overridden by subclasses in the specific editor.
	 * 
	 * @see AnchorPoint#bindToReference(String)
	 */
	public void synchronizeAnchorPoints() {

	}

	public boolean anchorPointsVisibility = false;

	public void setAnchorPointVisibility(boolean value) {
		for (Node node : this.lookupAll("AnchorPoint")) {
			AnchorPoint anchorPoint = (AnchorPoint) node;

			if (value) {
				anchorPointsVisibility = true;
				anchorPoint.setVisible(true);
			} else {
				anchorPointsVisibility = false;
				anchorPoint.setVisible(false);
			}
		}
		for (Node node : this.lookupAll("AnchorPointVirtual")) {
			AnchorPointVirtual anchorPoint = (AnchorPointVirtual) node;

			if (value) {
				anchorPointsVisibility = true;
				anchorPoint.setVisible(true);
			} else {
				anchorPointsVisibility = false;
				anchorPoint.setVisible(false);
			}
		}

	}

	/**
	 * Drop all connection between the anchor points found on this node and their
	 * corresponding targets. It takes care of the multiple selection.
	 * 
	 */
	public void dropOldConnections() {
		for (Node node : this.lookupAll("AnchorPoint")) {
			AnchorPoint anchorPoint = (AnchorPoint) node;
			if (anchorPoint.getTarget() != null) {
				if (!SelectionModel.getSelection().contains(anchorPoint.getTarget().getEntePadre().getParent()))
					anchorPoint.disconnect();
			}
		}
		for (Node node : this.lookupAll("AnchorPointVirtual")) {
			AnchorPointVirtual anchorPoint = (AnchorPointVirtual) node;
			if (anchorPoint.getTarget() != null) {
				if (!SelectionModel.getSelection().contains(anchorPoint.getTarget().getEntePadre().getParent())) {
					anchorPoint.disconnect();
				}
			}
		}
	}

	/*************************************************************************
	 * * AnchorPoint helpers - END
	 *************************************************************************/

	/*************************************************************************
	 * * Helpers
	 *************************************************************************/

	public List<FXMLeAttribute> ecoreAttributes;

	/**
	 * 
	 * Trigger model notifications for attribute single-valued in order to
	 * initialize place holders
	 * 
	 * @param mod eObject
	 */
	public void initializePlaceholders(EObject mod) {
		mod.eClass().getEAllAttributes().stream().filter(attr -> attr.getUpperBound() == 1).forEach(feature -> {
			mod.eSet(feature, mod.eGet(feature));
		});
	}

	/**
	 * Set the color to a specific component into fxml
	 * 
	 * @param placeholder component
	 * @param value       color to set
	 */
	public void setColorComponent(String placeholder, String value) {
		FXMLUtil.setBeanAttributes(ecoreAttributes, placeholder, value);
	}

	/**
	 * Validate the ente with custom code
	 */
	public void validate() {
	}

	public String getMetaClassName() {
		return this.graphicalElement.getElement().getName();
	}
	
	public String getFxmlPath () {
		return this.graphicalElement.getFxmlPath();
	}

	@Override
	public String toString() {
		return this.identifier.getValue();
	}
}
