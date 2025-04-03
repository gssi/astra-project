package it.gssi.astra.metaeditor.common.canvas;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import it.gssi.astra.metaeditor.common.LayoutScene;
import it.gssi.astra.metaeditor.common.canvas.section.CanvasSectionLayer;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Contexts;
import it.gssi.astra.metaeditor.common.dataManager.databinding.JFX2EMF.Converters;
import it.gssi.astra.metaeditor.common.ente.Ente;
import it.gssi.astra.metaeditor.common.grid.CanvasGrid;
import it.gssi.astra.metaeditor.common.treeView.CustomTreeView;
import it.gssi.astra.metaeditor.common.utility.EditorProperties;
import it.gssi.astra.metaeditor.common.utility.FXMLUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;

/**
 * This class is a UI component containing the canvas, the grid and the sections.
 * Being an extension of the {@link ScrollPane} is necessary to move within the {@link Canvas},
 * also provides a set of functions for zooming.
 */
public class ContainerCanvas extends ScrollPane {

	public Resource res;

	private Resource resPersistance;

	private AdapterFactoryEditingDomain editingDomain;

	private MetaEditorPersistence rootPersistence;

	private BiMap<EObject, Ente> viewModelMapping = HashBiMap.create();
	
	private Map<EObject, ElementPosition> allElementPositions = new HashMap<EObject, ElementPosition>();

	public TreeItem<String> treeRoot;

	@FXML
	private StackPane zoomableCanvas;

	@FXML
	private Group groupCanvas;

	@FXML
	private StackPane rootCanvas;

	@FXML
	private Canvas canvas;

	private static String BASE_PATH_FXML = EditorProperties.get("base.path");
	private static String FILE_NAME_FXML = EditorProperties.get("containerCanvas.fxml");

	public final double ZOOM_FACTOR = 1.1;

	public double zoomLevel = 0;

	KeyCombination zoomIN_MacOS = new KeyCodeCombination(KeyCode.CLOSE_BRACKET, KeyCombination.SHORTCUT_ANY);
	KeyCombination zoomOUT_MacOS = new KeyCodeCombination(KeyCode.SLASH, KeyCombination.SHORTCUT_ANY);
	
	KeyCombination zoomIN_Windows = new KeyCodeCombination(KeyCode.PLUS, KeyCombination.SHORTCUT_ANY);
	KeyCombination zoomOUT_Windows = new KeyCodeCombination(KeyCode.MINUS, KeyCombination.SHORTCUT_ANY);

	private CanvasGrid grid;
	
	private CanvasScrollHandler scrollHandler;

	private CanvasSectionLayer sectionLayer;

	public ContainerCanvas(Resource res, Resource resPersistance, MetaEditorPersistence rootPersistence,
			AdapterFactoryEditingDomain editingDomain) {

		this.res = res;
		this.resPersistance = resPersistance;
		this.rootPersistence = rootPersistence;
		this.editingDomain = editingDomain;
		
		for (ElementPosition elementPosition : this.getRootPersistence().getElementPositions()) {
			allElementPositions.put(elementPosition.getElement(), elementPosition);
		}

		FXMLUtil.loadFXML(this, BASE_PATH_FXML + FILE_NAME_FXML);

		treeRoot = new TreeItem<String>("root");

		CustomTreeView.createTreeView(res.getContents().get(0).eClass(), treeRoot);


		groupCanvas.layoutBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
			// keep it at least as large as the content
			zoomableCanvas.setMinWidth(newBounds.getWidth());
			zoomableCanvas.setMinHeight(newBounds.getHeight());
		});

		this.setPannable(true);
		this.viewportBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
			// use viewport size, if not too small for zoomTarget
			zoomableCanvas.setPrefSize(newBounds.getWidth(), newBounds.getHeight());
		});

		zoomableCanvas.setOnScroll(evt -> {
			if (evt.isShortcutDown()) {
				evt.consume();

				double direzione = evt.getDeltaY() > 0 ? ZOOM_FACTOR : 1 / ZOOM_FACTOR;

				if (direzione == ZOOM_FACTOR)
					zoomLevel += 1;
				else
					zoomLevel -= 1;

				zoom(direzione, new Point2D(evt.getX(), evt.getY()));
			}
		});

		canvas.getChildren().clear();
		rootCanvas.setVisible(true);

		res.getAllContents().next().eAdapters().add(new AdapterImpl() {

			public void notifyChanged(Notification notification) {
				
				if (!(notification.getNewValue() == (notification.getOldValue()))) {

					if(!((EStructuralFeatureImpl) notification.getFeature()).isContainment()) {
						
						String changedField = ((EStructuralFeatureImpl) notification.getFeature()).getName();
						String methodName = "on" + changedField.substring(0, 1).toUpperCase()
								+ changedField.substring(1) + "Changed";

						try {
							Method method = LayoutScene.getInstance().rootFX.getClass().getMethod(methodName, Object.class);
							method.invoke(LayoutScene.getInstance().rootFX, notification.getNewValue());
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
						
					}
				
				}

				if (notification.getEventType() == Notification.REMOVE
						|| notification.getEventType() == Notification.SET) {

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

						TreeIterator<EObject> sourceChildIterator = source.eAllContents();
						
						while (sourceChildIterator.hasNext()) { 
							
							Ente eChild = LayoutScene.getViewModelMap().get((sourceChildIterator.next()));
							LayoutScene.getViewModelMap().inverse().remove(eChild);
							LayoutScene.getInstance().getCanvas().getChildren().remove(eChild.getDraggableNode());
						}
						
						Platform.runLater(() -> {
							if (e.treeItem.getParent() != null) {
								e.treeItem.getParent().getChildren().remove(e.treeItem);
								//SelectionModel.clear(true);
							}
						});
					}
				}
				if (notification.getEventType() == Notification.ADD
						|| notification.getEventType() == Notification.SET) {

					if (notification.getOldValue() == null) {
						if (notification.getFeature() instanceof EReference) {

							EReference domainRef = (EReference) notification.getFeature();

							if (domainRef.isContainment()) {
								CanvasManagementImpl.getInstance().addElement((EObject) notification.getNewValue(),
										(EObject) notification.getNotifier(), domainRef);
								
								((EObject) notification.getNewValue()).eAllContents().forEachRemaining(child->{
									CanvasManagementImpl.getInstance().addElement((EObject) child,
											(EObject) child.eContainer(), ((EObject) child).eContainmentFeature());
								});
								
								Ente e = LayoutScene.getViewModelMap().get((EObject) notification.getNewValue());
								e.synchronizeAnchorPoints();
							}
						}
					}
				}

			}
		});
	}

	@FXML
	private void initialize() {
		scrollHandler = new CanvasScrollHandler(this);
	}

	public void load() {
		// Crea la griglia
		grid = new CanvasGrid(rootPersistence);
		this.getRootCanvas().getChildren().add(grid);
		
		// Porta la griglia dietro il canvas
		grid.toBack();

		// Carica le sezioni
		createSectionLayer();
		if(rootPersistence.getCanvasSections().isEmpty()) {
			sectionLayer.generateDefault();
		}
	}

	public void createDefault() {
		// Crea la griglia
		grid = new CanvasGrid(rootPersistence, 
				LayoutScene.getInstance().confInstanceRoot.getInitCanvasWidth(), 
				LayoutScene.getInstance().confInstanceRoot.getInitCanvasHeight());
		this.getRootCanvas().getChildren().add(grid);
		
		// Porta la griglia dietro il canvas
		grid.toBack();

		// Creare le sezioni di default
		createSectionLayer();
		sectionLayer.generateDefault();
	}

	public CanvasScrollHandler getScrollHandler() {
		return this.scrollHandler;
	}
	
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	public CanvasSectionLayer getSectionLayer() {
		return sectionLayer;
	}

	public void createSectionLayer() {
		CanvasSectionLayer sectionLayer = new CanvasSectionLayer();
		this.sectionLayer = sectionLayer;
		rootCanvas.getChildren().add(1, sectionLayer);
		
		JFX2EMF.bindValues(Contexts.CANVAS, rootPersistence, "canvasSections", sectionLayer, "sezioni", Converters.SECTIONS);
	}
	
	public void updateGrid(int width, int height) {
		grid.setGridWidth(width);
		grid.setGridHeight(height);
	}

	public CanvasGrid getGrid() {
		return grid;
	}

	public void zoom(double direzione, Point2D pivot) {
		Bounds groupBounds = groupCanvas.getLayoutBounds();
		final Bounds viewportBounds = this.getViewportBounds();

		// calculate pixel offsets from [0, 1] range
		double valX = this.getHvalue() * (groupBounds.getWidth() - viewportBounds.getWidth());
		double valY = this.getVvalue() * (groupBounds.getHeight() - viewportBounds.getHeight());

		// convert content coordinates to zoomTarget coordinates
		Point2D posInZoomTarget = rootCanvas.parentToLocal(groupCanvas.parentToLocal(pivot));

		// calculate adjustment of scroll position (pixels)
		Point2D adjustment = rootCanvas.getLocalToParentTransform()
				.deltaTransform(posInZoomTarget.multiply(direzione - 1));

		// do the resizing
		rootCanvas.setScaleX(direzione * rootCanvas.getScaleX());
		rootCanvas.setScaleY(direzione * rootCanvas.getScaleY());

		// refresh this scroll positions & content bounds
		this.layout();

		// convert back to [0, 1] range
		// (too large/small values are automatically corrected by ScrollPane)
		groupBounds = groupCanvas.getLayoutBounds();
		this.setHvalue((valX + adjustment.getX()) / (groupBounds.getWidth() - viewportBounds.getWidth()));
		this.setVvalue((valY + adjustment.getY()) / (groupBounds.getHeight() - viewportBounds.getHeight()));
	}

	public void zoom100() {

		rootCanvas.setScaleX(1);
		rootCanvas.setScaleY(1);

		this.setHvalue(0);
		this.setVvalue(0);

		zoomLevel = 0;

	}
	
	public void zoomPlus() {
		double direzione = 0;
		direzione = ZOOM_FACTOR;
		zoomLevel += 1;
		zoom(direzione, new Point2D(0, 0));
	}
	
	public void zoomMinus() {
		double direzione = 0;
		
		direzione = 1 / ZOOM_FACTOR;
		zoomLevel -= 1;
		zoom(direzione, new Point2D(0, 0));
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public StackPane getRootCanvas() {
		return rootCanvas;
	}

	public MetaEditorPersistence getRootPersistence() {
		return rootPersistence;
	}

	public BiMap<EObject, Ente> getViewModelMap() {
		return viewModelMapping;
	}
	
	public Map<EObject, ElementPosition> getAllElementPositions() {
		return allElementPositions;
	}

	public Resource getResource() {
		return res;
	}

	public Resource getResourcePersistance() {
		return resPersistance;
	}
}
